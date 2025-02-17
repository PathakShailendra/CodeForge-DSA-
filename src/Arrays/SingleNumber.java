package Arrays;

import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int s = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i+=2){
            if(i == nums.length-1)return nums[i];
            if(nums[i] != nums[i+1]){
                s = nums[i];
                break;
            }
        }
        return s;
    }
}
