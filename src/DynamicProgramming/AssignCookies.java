package DynamicProgramming;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int[][] dp = new int[g.length + 1][s.length + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, g, s, dp);
    }

    private int solve(int i, int j, int[] g, int[] s, int[][] dp) {
        if (i == g.length || j == s.length) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int result = 0;

        if (s[j] >= g[i]) {
            result = 1 + solve(i + 1, j + 1, g, s, dp);
        }

        result = Math.max(result, solve(i, j + 1, g, s, dp));

        return dp[i][j] = result;
    }

    // This code is correct but gives me Memory limit exceeded due to recursion stack
}
