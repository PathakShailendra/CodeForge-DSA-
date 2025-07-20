package DynamicProgramming.DPOnPartition;

public class BooleanExpression {
    private static int solve(String s, int i, int j, boolean isTrue, Integer[][][] dp) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue) return s.charAt(i) == 'T' ? 1 : 0;
            else return s.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue ? 1 : 0] != null) return dp[i][j][isTrue ? 1 : 0];

        int ways = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            char op = s.charAt(k);

            int lt = solve(s, i, k - 1, true, dp);
            int lf = solve(s, i, k - 1, false, dp);
            int rt = solve(s, k + 1, j, true, dp);
            int rf = solve(s, k + 1, j, false, dp);

            if (op == '&') {
                if (isTrue) ways += lt * rt;
                else ways += lt * rf + lf * rt + lf * rf;
            }
            else if (op == '|') {
                if (isTrue) ways += lt * rt + lt * rf + lf * rt;
                else ways += lf * rf;
            }
            else if (op == '^') {
                if (isTrue) ways += lt * rf + lf * rt;
                else ways += lt * rt + lf * rf;
            }
        }

        return dp[i][j][isTrue ? 1 : 0] = ways;
    }

    static int countWays(String s) {
        int N = s.length();
        Integer[][][] dp = new Integer[N][N][2]; // Use Integer for null checking
        return solve(s, 0, N - 1, true, dp);
    }
}
