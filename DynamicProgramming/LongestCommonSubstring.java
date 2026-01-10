package DynamicProgramming;
import java.util.*;
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],0);
        }
        System.out.println("Length of Longest Common Substring is: " + LCSUsingTabulation(str1, str2,dp));
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
        int ans = 0;
        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)){
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    ans = Math.max(ans,dp[ind1][ind2]);
                }else{
                    dp[ind1][ind2] =0;
                }
            }
        }
        return ans;
    }
}
