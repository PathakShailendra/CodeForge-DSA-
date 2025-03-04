package BinarySearch;

public class FirstAndLastPositionInArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int res[] = {-1,-1};
        int start  = 0;
        int end = n-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid]  == target){
                int i=mid;
                int j=mid;
                while (i >= 0 && nums[i] == target) i--;
                while (j < n && nums[j] == target) j++;
                res[0] = i + 1;
                res[1] = j - 1;
                break;
            }
            else if(nums[mid]>target)end=mid-1;
            else{
                start=mid+1;
            }
        }
        return res;
    }
}
