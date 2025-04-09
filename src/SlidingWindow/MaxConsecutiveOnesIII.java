package SlidingWindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        while(j < n) {
            while(j < n && (nums[j] == 1 || k > 0)) {
                if(nums[j] == 0)k--;
                j++;
            }
            max = Math.max(max, j-i+1);
            while(i < n && k == 0) {
                if(nums[i] == 0)k++;
                i++;
            }
        }
        return max-1;
    }
}
