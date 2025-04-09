package SlidingWindow;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int i = 0, count = 0, currSum = 0;

        for (int j = 0; j < nums.length; j++) {
            currSum += nums[j];

            while (currSum > goal) {
                currSum -= nums[i++];
            }

            count += j - i + 1;
        }

        return count;
    }

}
