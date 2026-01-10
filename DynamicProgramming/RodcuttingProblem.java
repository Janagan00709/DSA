package DynamicProgramming;

import java.util.*;

class RodcuttingProblem {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,10};
        int N = 5;
        int[][] dp = new int[N][N+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        } 
        System.out.println(rodcuttingUsingTabulation(arr));
    }
    //Using Tabulation
    public static int rodcuttingUsingTabulation(int[] price) {

        int n = price.length;          // rod length
        int[][] dp = new int[n][n + 1];
    
        // Base case: using only length 1 rod
        for (int len = 0; len <= n; len++) {
            dp[0][len] = len * price[0];
        }
    
        for (int ind = 1; ind < n; ind++) {
            for (int len = 0; len <= n; len++) {
    
                int notTake = dp[ind - 1][len];
                int take = Integer.MIN_VALUE;
    
                int rodLength = ind + 1;
                if (rodLength <= len) {
                    take = price[ind] + dp[ind][len - rodLength];
                }
    
                dp[ind][len] = Math.max(take, notTake);
            }
        }
    
        return dp[n - 1][n];
    }


    //Using Dp
    public static int rodcuttingUsingDp(int ind, int N,int[] price,int[][] dp) {
        if(ind == 0){
            return N * price[0];
        }
        if(dp[ind][N]!=-1){
            return dp[ind][N];
        }
        int NotTake = 0 + rodcuttingUsingDp(ind - 1, N,price,dp);
        int Take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength<=N){
            Take = price[ind] + rodcuttingUsingDp(ind,N - rodLength,price,dp);
        }
        return dp[ind][N] = Math.max(Take,NotTake);
    }
    // Normal recursive version (without DP)
    public static int rodcutting(int ind, int N,int[] price) {
        if(ind == 0){
            return N * price[0];
        }
        int NotTake = 0 + rodcutting(ind - 1, N,price);
        int Take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength<=N){
            Take = price[ind] + rodcutting(ind,N - rodLength,price);
        }
        return Math.max(Take,NotTake);
    }
}

