package Arrays;

public class moveZeroes {
    public void moveZeroe(int[] nums) {
        if(nums.length > 1){
            int j = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0)nums[j++] = nums[i];
            }
            for(int k = j; k < nums.length; k++){
                nums[k] = 0;
            }
        }
    }
}
