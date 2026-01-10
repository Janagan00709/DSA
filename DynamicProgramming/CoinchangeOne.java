package DynamicProgramming;

import java.util.*;

class CoinchangeOne {
    public static void main(String[] args) {
        int[] arr = {9,6,5,1};
        int n = arr.length;
        int target = 7;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        } 
        System.out.println(mincoinsUsingTabulation(n-1,arr,target,dp));
    }
    //Using Tabulation
    public static int mincoinsUsingTabulation(int n, int[] arr,int target,int[][] dp) {
        if (target < 0) return Integer.MAX_VALUE;
        for(int T=0;T<=target;T++){
            if(T % arr[0] == 0){
                dp[0][T] = T / arr[0];
            }else{
                dp[0][T]= Integer.MAX_VALUE;
            }
        }
        for(int ind =1;ind<=n;ind++){
            for(int T=0;T<=target;T++){
                int NotTake = 0 + dp[ind - 1][T];
                int Take = Integer.MAX_VALUE;
                if(arr[ind]<=T){
                    int res = dp[ind][T-arr[ind]];
                    if(res!=Integer.MAX_VALUE){
                        Take = 1+ res;
                }
            }
            dp[ind][T]=Math.min(Take,NotTake);
            }
        }
        return dp[n][target];
        
    }
    //Using DP
    public static int mincoinsUsingdp(int ind, int[] arr,int T,int[][] dp) {
        if (T < 0) return Integer.MAX_VALUE;
        if(dp[ind][T]!=-1){
            return dp[ind][T];
        }
        if(ind == 0){
            if(T%arr[ind]==0){
                return T/arr[ind];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int NotTake = 0 + mincoinsUsingdp(ind - 1, arr,T,dp);
        int Take = Integer.MAX_VALUE;
        if(arr[ind]<=T){
            int res = mincoinsUsingdp(ind , arr,T-arr[ind],dp);
            if(res!=Integer.MAX_VALUE){
                Take = 1+ res;
            }
        }
        return dp[ind][T]=Math.min(Take,NotTake);
    }

    // Normal recursive version (without DP)
    public static int mincoins(int ind, int[] arr,int T) {
        if (T < 0) return Integer.MAX_VALUE;
        if(ind == 0){
            if(T%arr[0]==0){
                return T/arr[0];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int NotTake = 0 + mincoins(ind - 1, arr,T);
        int Take = Integer.MAX_VALUE;
        if(arr[ind]<=T){
            int res = 1 + mincoins(ind , arr,T-arr[ind]);
            if(res!=Integer.MAX_VALUE){
                Take = 1+ res;
            }
        }
        return Math.min(Take,NotTake);
    }
}

