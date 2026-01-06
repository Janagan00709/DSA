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
       System.out.println("Using Memoization:");
       System.out.println(f(n-1,heights,dp));
       System.out.println("Using Tabulation:");
       System.out.println(FrogUsingTabulation(n,heights,dps));
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
    


// --------------------------------------- Using RECURSION ONLY --------------------------------------------


// class Frog{
//     public static void main(String[] args){
//        int[] heights = {30 , 10, 60 , 10, 60, 50};
//        int n = heights.length;
//        System.out.println(f(n-1,heights));
//     }
//     public static int f(int ind, int[] heights){
//         if(ind==0){
//             return 0;
//         }
//         int left = f(ind-1,heights) + Math.abs(heights[ind]-heights[ind-1 ]);
//         int right = Integer.MAX_VALUE;
//         if(ind > 1){
//             right = f(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);  
//         }   
//         return Math.min(left,right);
//     }
    
// }
