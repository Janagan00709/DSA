package DynamicProgramming;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class LongestIncreasingSubsequence {
    public static void main(String[] args) {;
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("Using recursion:");
        System.out.println(LIS(0,-1,arr));
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0;i< dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Using Dynamic Programming:");
        System.out.println(LISUsingdp(0,-1,arr,dp));
    }
    public static int LISUsingdp(int ind,int prev,int[] arr,int[][] dp){
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int len = 0 + LISUsingdp(ind+1,prev,arr,dp);
        if(prev==-1 || arr[ind] > prev){
            len = Math.max(1 + LISUsingdp(ind+1,ind,arr,dp),len);
        }
        //dp[ind][-1] not possible, that's why prev+1
        return dp[ind][prev+1] = len;
    }
    public static int LIS(int ind,int prev,int[] arr){
        if(ind==arr.length){
            return 0;
        }
        int len = 0 + LIS(ind+1,prev,arr);
        if(prev==-1 || arr[ind] > prev){
            len = Math.max(1 + LIS(ind+1,ind,arr),len);
        }
        return len;
    }
}
