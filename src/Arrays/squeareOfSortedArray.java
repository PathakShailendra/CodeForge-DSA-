package Arrays;

public class squeareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int []res = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        int p = nums.length-1;
        while(i <= j){
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){
                res[p--] = nums[i]*nums[i];
                i++;
            }
            else{
                res[p--] = nums[j]*nums[j];
                j--;
            }
        }
        return res;
    }
}
