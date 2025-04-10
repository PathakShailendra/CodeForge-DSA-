package SlidingWindow;

public class MaxPointsFromCards {
    public int maxScore(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int n = nums.length;
        int windowSize = n - k;
        if (windowSize == 0) return totalSum;

        int currentSum = 0;
        for (int i = 0; i < windowSize; i++) {
            currentSum += nums[i];
        }

        int minSubarraySum = currentSum;
        for (int i = windowSize; i < n; i++) {
            currentSum += nums[i] - nums[i - windowSize];
            minSubarraySum = Math.min(minSubarraySum, currentSum);
        }

        return totalSum - minSubarraySum;
    }
}
