package BinarySearch;

public class FindNthRootOfM {
    private long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
            if (result > Integer.MAX_VALUE) return Long.MAX_VALUE; // Overflow handle karo
        }
        return result;
    }

    public int nthRoot(int n, int m) {
        // code here
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = power(mid, n);

            if (power == m) return mid;
            else if (power > m) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
