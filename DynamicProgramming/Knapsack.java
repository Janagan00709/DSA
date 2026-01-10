package DynamicProgramming;

import java.util.*;

class Knapsack {
    public static void main(String[] args) {
        int[] wt = {3,4,5};
        int[] val = {30,50,60};
        int n = wt.length;
        int W = 8;
        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("Knapsack Problem using normal approach");
        System.out.println(knapsack(n-1,W,wt,val));
        System.out.println("Knapsack Problem using Memoization:");
        System.out.println(knapsackUsingDp(n-1,W,wt,val,dp));
        System.out.println("Knapsack Problem using Tabulation:");
        System.out.println(knapsackUsingTabulation(n,W,wt,val,dp));
        System.out.println("Knapsack Problem using Space Optimization:");
        System.out.println(KnapsackspaceOptimal(n,W,wt,val)); 
        System.out.println("Knapsack Problem using Single Array Optimization:");      
        System.out.println(KnapsackOptimal(n,W,wt,val));
    }
     //Single Array Optimization
    public static int KnapsackOptimal(int n,int maxWeight,int[] wt,int[] val) {
        int[] prev = new int[maxWeight+1];
        for(int W = wt[0];W<=maxWeight;W++){
            prev[W]=val[0];
        }
        for(int ind = 1;ind <n;ind++){
            for(int W=maxWeight;W>=0;W--){
                int NotTake = 0 + prev[W];
                int Take = Integer.MIN_VALUE;
                if(wt[ind]<=W){
                    Take = val[ind] + prev[W-wt[ind]];
                }
                prev[W] = Math.max(Take,NotTake); 
            }
        }
        return prev[maxWeight];
    }
    public static int KnapsackspaceOptimal(int n,int maxWeight,int[] wt,int[] val) {
        int[] prev = new int[maxWeight+1];
        int[] cur = new int[maxWeight+1];
        for(int W = wt[0];W<=maxWeight;W++){
            prev[W]=val[0];
        }
        for(int ind = 1;ind <n;ind++){
            for(int W=0;W<=maxWeight;W++){
                int NotTake = 0 + prev[W];
                int Take = Integer.MIN_VALUE;
                if(wt[ind]<=W){
                    Take = val[ind] + prev[W-wt[ind]];
                }
                cur[W] = Math.max(Take,NotTake); 
            }
            prev = cur;
        }
        return prev[maxWeight];
    }
    public static int knapsackUsingTabulation(int n,int maxWeight,int[] wt,int[] val,int[][] dp) {
        for(int W = wt[0];W<=maxWeight;W++){
            dp[0][W]=val[0];
        }
        for(int ind = 1;ind <n;ind++){
            for(int W=0;W<=maxWeight;W++){
                int NotTake = 0 + dp[ind - 1][W];
                int Take = Integer.MIN_VALUE;
                if(wt[ind]<=W){
                    Take = val[ind] + dp[ind - 1][W-wt[ind]];
                }
                dp[ind][W] = Math.max(Take,NotTake); 
            }
        }
        return dp[n-1][maxWeight];
    }

 

    public static int knapsackUsingDp(int ind, int W,int[] wt,int[] val,int[][] dp) {
        if(ind == 0){
            if(wt[0]<=W){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[ind][W]!=-1){
            return dp[ind][W];
        }
        int NotTake = 0 + knapsackUsingDp(ind - 1, W, wt, val,dp);
        int Take = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            Take = val[ind] + knapsackUsingDp(ind - 1 , W - wt[ind],wt,val,dp);
        }
        return dp[ind][W] = Math.max(Take,NotTake);
    }

    // Normal recursive version (without DP)
    public static int knapsack(int ind, int W,int[] wt,int[] val) {
        if(ind == 0){
            if(wt[0]<=W){
                return val[0];
            }else{
                return 0;
            }
        }
        int NotTake = 0 + knapsack(ind - 1, W, wt, val);
        int Take = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            Take = val[ind] + knapsack(ind - 1 , W - wt[ind],wt,val);
        }
        return Math.max(Take,NotTake);
    }
}

