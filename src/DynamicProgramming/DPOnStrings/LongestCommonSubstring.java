package DynamicProgramming.DPOnStrings;

public class LongestCommonSubstring {
    static int maxLen =0;
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Memoization table
        Integer[][] dp = new Integer[n + 1][m + 1];
        maxLen = 0;

        // Solve for all (i, j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                solve(i, j, s1, s2, dp);
            }
        }

        return maxLen;
    }
    private static int solve(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i == 0 || j == 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2, dp);
            maxLen = Math.max(maxLen, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}
