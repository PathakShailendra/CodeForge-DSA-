package math;

public class SqrtBinarySearch {
    public static int mySqrt(int x) {
        if (x == 0) return 0;

        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) { // Use long to prevent overflow
                ans = mid; // Store possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println("Square Root: " + mySqrt(x));
    }
}

