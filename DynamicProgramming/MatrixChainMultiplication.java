package DynamicProgramming;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class MatrixChainMultiplication {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int[] arr = {10,20,30,40,50};
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Using Recursion + Memoization");
        System.out.println(MCM(1,arr.length-1,arr,dp));
        System.out.println("Using Tabulation");
        System.out.println(MCMUsingTabulation(arr,dp));
    }
    public static int MCM(int i,int j,int[] arr,int[][] dp){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + MCM(i,k,arr,dp) +MCM(k+1,j,arr,dp);
            min = Math.min(min,steps);
        }
        return dp[i][j] = min;
    }
    public static int MCMUsingTabulation(int[] arr,int[][] dp){
        for(int length=2;length<=arr.length-1;length++){
            for(int i=1;i<=arr.length-length;i++){
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<=j-1;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    dp[i][j] = Math.min(dp[i][j],steps);
                }
            }
        }
        return dp[1][arr.length-1];
    }
}
