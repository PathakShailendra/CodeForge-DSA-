package DynamicProgramming.DPOnPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutStickTab {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;

        List<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        for (int cut : cuts) cutList.add(cut);
        cutList.add(n);

        Collections.sort(cutList);

        int m = cutList.size();
        int[][] dp = new int[m][m];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i + 1 >= j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i + 1; ind < j; ind++) {
                    int cost = cutList.get(j) - cutList.get(i) + dp[i][ind] + dp[ind][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[0][m - 1];
    }
}
