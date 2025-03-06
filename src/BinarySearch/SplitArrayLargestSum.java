package BinarySearch;

public class SplitArrayLargestSum {
    public boolean isPossible(int[] nums, int k, int mid) {
        int partitions = 1;
        int currSum = 0;
        for(int num : nums) {
            if(currSum + num > mid) {
                partitions++;
                currSum = num;
                if(partitions > k)  return false;
            }
            else {
                currSum += num;
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(isPossible(nums, k, mid)) {
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return low;
    }
}
