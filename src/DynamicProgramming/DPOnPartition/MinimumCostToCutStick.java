package DynamicProgramming.DPOnPartition;

import java.util.Arrays;

public class MinimumCostToCutStick {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] newCuts = new int[c + 2];
        for (int i = 0; i < c; i++) newCuts[i + 1] = cuts[i];
        newCuts[0] = 0;
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[c + 2][c + 2];

        return dfs(0, c + 1, newCuts, dp);


    }

    private int dfs(int i, int j, int[] cuts, int[][] dp) {
        if (j - i <= 1) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int cost = cuts[j] - cuts[i] + dfs(i, k, cuts, dp) + dfs(k, j, cuts, dp);
            minCost = Math.min(minCost, cost);
        }

        dp[i][j] = minCost;
        return minCost;
    }
}
