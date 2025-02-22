package Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length;i++){
            if(nums[i] == 0)count[0]++;
            else if(nums[i] == 1)count[1]++;
            else count[2]++;
        }
        int k = 0;
        for(int i = 0; i < count.length;i++){
            while(count[i] >0){
                nums[k++]=i;
                count[i]--;
            }
        }
    }
}
