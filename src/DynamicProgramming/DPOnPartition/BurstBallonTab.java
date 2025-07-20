package DynamicProgramming.DPOnPartition;

import java.util.ArrayList;
import java.util.List;

public class BurstBallonTab {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int num : nums) list.add(num);
        list.add(1);

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                for (int idx = i; idx <= j; idx++) {
                    int cost = list.get(i - 1) * list.get(idx) * list.get(j + 1)
                            + dp[i][idx - 1] + dp[idx + 1][j];
                    dp[i][j] = Math.max(dp[i][j], cost);
                }
            }
        }

        return dp[1][n];
    }
}
