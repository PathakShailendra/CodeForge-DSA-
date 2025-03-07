package BinarySearch;

public class SmallestDivisorThreshhold {
    static int divide(int arr[] , int mid){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += (int)Math.ceil((double)arr[i]/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = 0;
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : nums)if(num > high)high = num;
        while(low <= high){
            int mid = low+(high-low)/2;
            int thresh = divide(nums, mid);
            if(thresh <= threshold){
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}
