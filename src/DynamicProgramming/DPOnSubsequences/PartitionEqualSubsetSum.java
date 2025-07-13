package DynamicProgramming.DPOnSubsequences;

public class PartitionEqualSubsetSum {
    private static boolean solve(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        if (dp[index][target] != null) return dp[index][target];

        boolean notPick = solve(index - 1, target, arr, dp);
        boolean pick = false;
        if (arr[index] <= target) {
            pick = solve(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = pick || notPick;
    }
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for(int i : nums) sum += i;
        if (sum % 2 != 0) {
            return false;
        }
        Boolean[][] dp = new Boolean[N][sum + 1];
        return solve(N - 1, sum/2, nums, dp);
    }
}
