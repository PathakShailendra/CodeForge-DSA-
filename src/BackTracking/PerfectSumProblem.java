package BackTracking;

public class PerfectSumProblem {
    public int perfectSum(int[] nums, int target) {
        return backtrack(nums, 0, 0, target);
    }

    private int backtrack(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int include = backtrack(nums, i + 1, sum + nums[i], target);
        int exclude = backtrack(nums, i + 1, sum, target);

        return include + exclude;
    }
}
