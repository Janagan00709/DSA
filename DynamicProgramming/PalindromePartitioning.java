package DynamicProgramming;

import java.util.*;
class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "babacbcbadcede";
        int[] dp = new int[str.length()];
        Arrays.fill(dp,-1);
        System.out.println(PP(0,str,dp)-1);
    }
    public static int PP(int i,String str,int[] dp){
        if(i==str.length()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        String temp = "";
        int cost = Integer.MAX_VALUE;
        int mincost = Integer.MAX_VALUE;
        for(int j=i;j<str.length();j++){
            temp+=str.charAt(j);
            if(isPalindrome(temp)){
                cost = 1 + PP(j+1,str,dp);
                mincost = Math.min(cost,mincost);
            }
        }
        return dp[i]= mincost;
    }
    public static int PPUsingTabulation(String str,int[] dp){
        dp[str.length()]=0;
        for(int i=str.length()-1;i>=0;i--){
            String temp = "";
            int cost = Integer.MAX_VALUE;
            int mincost = Integer.MAX_VALUE;
            for(int j=i;j<str.length();j++){
                temp+=str.charAt(j);
                if(isPalindrome(temp)){
                    cost = 1 + dp[j+1];
                    mincost = Math.min(cost,mincost);
                }
            }
            dp[i]= mincost;
        }
        return dp[0]-1;
    }
    //Using Recursion
    public static int PPUsingRecursion(int i,String str){
        if(i==str.length()){
            return 0;
        }
        String temp = "";
        int cost = Integer.MAX_VALUE;
        int mincost = Integer.MAX_VALUE;
        for(int j=i;j<str.length();j++){
            temp+=str.charAt(j);
            if(isPalindrome(temp)){
                cost = 1 + PPUsingRecursion(j+1,str);
                mincost = Math.min(cost,mincost);
            }
        }
        return mincost;
    }
    public static boolean isPalindrome(String str){
        int i =0,j=str.length() - 1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
