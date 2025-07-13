package DynamicProgramming.DPOnSubsequences;

public class TargetSumTab {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if ((target + totalSum) % 2 != 0 || (target + totalSum) < 0) return 0;

        int sum = (target + totalSum) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int s = 0; s <= sum; s++) {
                dp[i + 1][s] = dp[i][s];

                if (s >= nums[i]) {
                    dp[i + 1][s] += dp[i][s - nums[i]];
                }
            }
        }

        return dp[n][sum];
    }
}
