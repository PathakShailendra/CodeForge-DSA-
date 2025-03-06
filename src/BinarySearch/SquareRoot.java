package BinarySearch;

public class SquareRoot {
    int floorSqrt(int n) {
        // Your code here
        if(n == 1) return 1;
        int ans = 0;
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid*mid == n) {
                ans = mid;
                break;
            }
            else if(mid * mid > n) {
                high = mid-1;
            }
            else {
                ans = mid;
                low = mid+1;
            }
        }
        return ans;
    }
}
