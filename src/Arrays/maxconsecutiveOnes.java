package Arrays;

public class maxconsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp = 0;
        for(int num: nums){
            if(num == 1)temp++;
            else temp = 0;
            count = Math.max(count, temp);
        }
        return count;
    }
}
