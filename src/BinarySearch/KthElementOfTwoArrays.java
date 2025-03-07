package BinarySearch;

public class KthElementOfTwoArrays {
    public int kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        // Ensure arr1 is the smaller array
        if (n > m) return kthElement(arr2, arr1, m, n, k);

        int low = Math.max(0, k - m), high = Math.min(k, n);

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int left1 = (cut1 > 0) ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int left2 = (cut2 > 0) ? arr2[cut2 - 1] : Integer.MIN_VALUE;
            int right1 = (cut1 < n) ? arr1[cut1] : Integer.MAX_VALUE;
            int right2 = (cut2 < m) ? arr2[cut2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = cut1 - 1; // Move left
            } else {
                low = cut1 + 1; // Move right
            }
        }
        return -1;
    }
}
