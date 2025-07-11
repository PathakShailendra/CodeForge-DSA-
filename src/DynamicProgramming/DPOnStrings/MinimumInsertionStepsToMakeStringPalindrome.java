package DynamicProgramming.DPOnStrings;

public class MinimumInsertionStepsToMakeStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return n - solve(0, n - 1, s, dp);
    }

    private int solve(int i, int j, String s, Integer[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != null) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + solve(i + 1, j - 1, s, dp);
        } else {
            dp[i][j] = Math.max(
                    solve(i + 1, j, s, dp),
                    solve(i, j - 1, s, dp)
            );
        }

        return dp[i][j];
    }
}
