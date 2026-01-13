package DynamicProgramming;

import java.util.*;

public class LongestCommonSubstring {
    static int maxLen = 0;

    public static void main(String[] args) {
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        maxLen = 0;
        LCSUsingDp(n - 1, m - 1, str1, str2, dp);
        System.out.println("Length of Longest Common Substring is: " + LCSUsingTabulation(str1, str2, dp));
        System.out.println("Using DP: " + maxLen);
    }

    public static int LCSUsingDp(int ind1, int ind2, String str1, String str2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            dp[ind1][ind2] = 1 + LCSUsingDp(ind1 - 1, ind2 - 1, str1, str2, dp);
            maxLen = Math.max(maxLen, dp[ind1][ind2]);
            return dp[ind1][ind2];
        } else {
            dp[ind1][ind2] = 0;
            LCSUsingDp(ind1 - 1, ind2, str1, str2, dp);
            LCSUsingDp(ind1, ind2 - 1, str1, str2, dp);
            return dp[ind1][ind2];
        }
    }

    public static int LCSUsingTabulation(String str1, String str2, int[][] dp) {
        int n = str1.length();
        int m = str2.length();
        for (int ind2 = 0; ind2 <= m; ind2++) {
            dp[0][ind2] = 0;
        }
        for (int ind1 = 0; ind1 <= n; ind1++) {
            dp[ind1][0] = 0;
        }
        int ans = 0;
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    ans = Math.max(ans, dp[ind1][ind2]);
                } else {
                    dp[ind1][ind2] = 0;
                }
            }
        }
        return ans;
    }
    public static int LCSUsingRecursion(String str1, String str2, int n, int m, int count) {
        if (n == 0 || m == 0) {
            return count;
        }
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            count = LCSUsingRecursion(str1, str2, n - 1, m - 1, count + 1);
        }
        count = Math.max(count, Math.max(LCSUsingRecursion(str1, str2, n - 1, m, 0),
                LCSUsingRecursion(str1, str2, n, m - 1, 0)));
        return count;
    }
}
