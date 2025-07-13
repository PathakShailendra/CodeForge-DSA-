package DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class PerfectSumProblem {
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        // Initialize dp with -1 to represent uncomputed states
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countSubsets(n - 1, target, nums, dp);
    }

    private int countSubsets(int index, int target, int[] nums, int[][] dp) {
        // Base Case
        if (index == 0) {
            if (target == 0 && nums[0] == 0) return 2; // include and exclude
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = countSubsets(index - 1, target, nums, dp);
        int take = 0;
        if (nums[index] <= target) {
            take = countSubsets(index - 1, target - nums[index], nums, dp);
        }

        dp[index][target] = (take + notTake) % 1000000007;
        return dp[index][target];
    }
}
