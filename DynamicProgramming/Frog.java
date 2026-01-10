package DynamicProgramming;

import java.util.*;
class Frog{
    public static void main(String[] args){
       int[] heights = {30 , 10, 60 , 10, 60, 50};
       int n = heights.length;
       int[] dp = new int[n+1];
       Arrays.fill(dp, -1);
       int[] dps = new int[n+1];
       Arrays.fill(dps, -1);
       System.out.println("Using Recursion:");
       System.out.println(f(n-1,heights));
       System.out.println("Using Memoization:");
       System.out.println(f(n-1,heights,dp));
       System.out.println("Using Tabulation:");
       System.out.println(FrogUsingTabulation(n,heights,dps));
    }
    //Using Recursion
    public static int f(int ind, int[] heights){
        if(ind==0){
            return 0;
        }
        int left = f(ind-1,heights) + Math.abs(heights[ind]-heights[ind-1 ]);
        int right = Integer.MAX_VALUE;
        if(ind > 1){
            right = f(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);  
        }   
        return Math.min(left,right);
    }
    // Memoization Method
    public static int f(int ind, int[] heights,int[] dp){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int left = f(ind-1,heights,dp) + Math.abs(heights[ind]-heights[ind-1 ]);
        int right = Integer.MAX_VALUE;
        if(ind > 1){
            right = f(ind-2,heights,dp ) + Math.abs(heights[ind]-heights[ind-2]);  
        }   
        dp[ind] = Math.min(left,right);
        return dp[ind]; 
    }
    // Tabulation Method
    public static int FrogUsingTabulation(int n, int[] heights,int[] dps){ 
        dps[0]=0;
        for(int i=1;i<n;i++){
            int firstStep = dps[i-1] + Math.abs(heights[i]-heights[i-1 ]);
            int SecondStep = Integer.MAX_VALUE;
            if(i > 1){
                SecondStep = dps[i - 2] + Math.abs(heights[i]-heights[i-2]);  
            }   
            dps[i] = Math.min(firstStep,SecondStep);
        }
        return dps[n-1]; 
    }
    public static int FrogwithspaceOptimation(int n, int[] heights,int[] dps){ 
        int prev=0;
        int prev2=0;
        for(int i=1;i<n;i++){
            int firstStep = prev + Math.abs(heights[i]-heights[i-1 ]);
            int SecondStep = Integer.MAX_VALUE;
            if(i > 1){
                SecondStep = prev2 + Math.abs(heights[i]-heights[i-2]);  
            }   
            int curr = Math.min(firstStep,SecondStep);
            prev2=prev;
            prev=curr;
        } 
        return prev; 
    }
                
}
    


// --------------------------------------- For Understand Recursion ONLY --------------------------------------------
/*

class Main {
    public static void main(String[] args) {
        int[] arr = {15, 4, 1, 14, 15};
        int k = 3;
        int min = Integer.MAX_VALUE;
        System.out.println(frog(arr.length-1,k,arr,min));
    }
    public static int frog(int ind,int k,int[] arr,int min){
        if(ind == 0){
            return 0;
        }
        for(int i=1;i<=k;i++){
            if(ind - i >= 0){
                System.out.println("f("+ind+") =>"+" ind: "+ind +", i: "+i);
                int jumps = frog(ind-i,k,arr,min)+Math.abs(arr[ind-i]-arr[ind]);
                min = Math.min(jumps,min);
                System.out.println("Jumps: "+ jumps + ", min: " + min);
            }
        }
        return min;
    }
}
*/

// --------------------------------------- Using Dynamic Programing --------------------------------------------
/*
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr = {15, 4, 1, 14, 15};
        int k = 3;
        int min = Integer.MAX_VALUE;
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        System.out.println(frog(arr.length-1,k,arr,min,dp));
    }
    public static int frog(int ind,int k,int[] arr,int min,int[] dp){
        if(dp[ind]!=-1){
            return dp[ind];
        }
        if(ind == 0){
            return 0;
        }
        for(int i=1;i<=k;i++){
            if(ind - i >= 0){
                System.out.println("f("+ind+") =>"+" ind: "+ind +", i: "+i);
                int jumps = frog(ind-i,k,arr,min,dp)+Math.abs(arr[ind-i]-arr[ind]);
                min = Math.min(jumps,min);
                System.out.println("Jumps: "+ jumps + ", min: " + min);
                dp[ind]=min;
            }
            
            
        }
        return min;
    }
}
*/