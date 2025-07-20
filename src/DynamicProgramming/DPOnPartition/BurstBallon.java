package DynamicProgramming.DPOnPartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallon {
    private int solve(int i, int j, List<Integer> list, int [][]dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = 0;

        for(int idx = i; idx <= j; idx++) {
            int cost = (list.get(i-1) * list.get(idx) * list.get(j+1)) +
                    solve(i, idx-1, list, dp) + solve(idx+1, j, list, dp);

            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n+2][n+2];
        for(int []arr : dp) Arrays.fill(arr, -1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num : nums)list.add(num);
        list.add(1);

        return solve(1, n, list, dp);
    }
}
