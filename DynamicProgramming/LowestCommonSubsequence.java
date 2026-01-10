package DynamicProgramming;


import java.util.*;
class LowestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "acd";
        String str2 = "ced";
        int n = str1.length();
        System.out.println("Using Recursion:");
        System.out.println(LCS(str1.length()-1,str2.length()-1,str1,str2));
        //System.out.println("Using Dynamic Programming: ");
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        //System.out.println(LCSUsingDp(str1.length()-1,str2.length()-1,str1,str2,dp));
        System.out.println("Using Tabulation: ");
        System.out.println(LCSUsingTabulation(str1,str2,dp));
        System.out.println("Using space Optimization: ");
        System.out.println(LCSUsingSpaceOptimization(str1,str2));
        System.out.println(PrintingLCS(str1,str2));
    }
    public static String PrintingLCS(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        
        // DP table
        int[][] dp = new int[n + 1][m + 1];
        
        // Base cases already 0 by default, so loops not required
        
        // Fill DP table
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        
        // Length of LCS
        int len = dp[n][m];
        
        // Use char array instead of String
        char[] ans = new char[len];
        int index = len - 1;
        
        int i = n, j = m;
        
        // Backtracking
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans[index] = str1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return new String(ans);

    }
    public static int LCSUsingSpaceOptimization(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];
        for(int ind2 = 0;ind2<=m;ind2++){
            prev[ind2]=0;
        }
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)){
                    cur[ind2] = 1 + prev[ind2 - 1];
                }else{
                    cur[ind2] = Math.max(cur[ind2], cur[ind2 - 1]);
                }
            }
            cur = prev;
        }
        return prev[m];
    }
    public static int LCSUsingTabulation(String str1, String str2,int[][] dp){
        int n = str1.length();
        int m = str2.length();
        for(int ind2 = 0;ind2<=m;ind2++){
            dp[0][ind2]=0;
        }
        for(int ind1 = 0;ind1<=n;ind1++){
            dp[ind1][0]=0;
        }
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)){
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int LCSUsingDp(int ind1,int ind2, String str1, String str2,int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(str1.charAt(ind1) == str2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + LCSUsingDp(ind1 - 1, ind2 - 1,str1,str2,dp);
        }
        return dp[ind1][ind2] = Math.max(LCSUsingDp(ind1-1, ind2 , str1,str2,dp),LCSUsingDp(ind1, ind2 - 1 , str1,str2,dp));
    }
    public static int LCS(int ind1,int ind2, String str1, String str2){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(str1.charAt(ind1) == str2.charAt(ind2)){
            return 1 + LCS(ind1 - 1, ind2 - 1,str1,str2);
        }
        return Math.max(LCS(ind1-1, ind2 , str1,str2),LCS(ind1, ind2 - 1 , str1,str2));
    }
}
