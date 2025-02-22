package Arrays;

public class rearraangeElementBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result[posIndex] = nums[i];
                posIndex += 2;
            }
            else {
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return result;
    }
}
