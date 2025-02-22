package Arrays;

public class MaorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
