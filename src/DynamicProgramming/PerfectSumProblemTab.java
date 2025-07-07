package DynamicProgramming;

public class PerfectSumProblemTab {
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int mod = 1000000007;
        int[][] dp = new int[n][target + 1];

        // Base Case
        // If first element is 0, then two ways to make 0: include or exclude
        for(int i = 0; i < n; i++) dp[i][0] = 1;
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= target)
                dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = dp[i - 1][sum];
                int take = 0;
                if (nums[i] <= sum)
                    take = dp[i - 1][sum - nums[i]];

                dp[i][sum] = (notTake + take) % mod;
            }
        }

        return dp[n - 1][target];
    }
}
