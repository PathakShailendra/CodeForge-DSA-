package Arrays;

public class rotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Agar k bada hai toh modulo lo

        reverse(nums, 0, n - 1); // Step 1: Pura array reverse
        reverse(nums, 0, k - 1); // Step 2: Pehle k elements reverse
        reverse(nums, k, n - 1); // Step 3: Baaki ke elements reverse
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
