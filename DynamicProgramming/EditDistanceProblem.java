package DynamicProgramming;

import java.util.*;
class EditDistanceProblem {
    public static void main(String[] args) {
        String str1="horse";
        String str2 = "ros";
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // System.out.println(EditDistance(str1.length()-1,str2.length()-1,str1,str2,dp));
        System.out.println(EditDistanceUsingTabulation(str1,str2,dp));
    }
    public static int EditDistanceUsingTabulation(String str1,String str2,int[][] dp){
        for(int i=0;i<=str1.length();i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=str2.length();j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
               if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                } else{
                    dp[i][j] = min(1 + dp[i][j-1],1 + dp[i-1][j],1 + dp[i-1][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
    public static int EditDistance(int i,int j,String str1,String str2,int[][] dp){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(str1.charAt(i)==str2.charAt(j)){
            return dp[i][j] = 0 + EditDistance(i-1,j-1,str1,str2,dp);
        }
        return dp[i][j] = min(1 + EditDistance(i,j-1,str1,str2,dp),1 + EditDistance(i-1,j,str1,str2,dp),1 + EditDistance(i-1,j-1,str1,str2,dp));
    }
    public static int min(int a, int b, int c){
        if(a<b && a<c){
            return a;
        }else if(b<a && b<c){
            return b;
        }else{
            return c;
        }
    }
}
