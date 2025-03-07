package BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partX = (low + high) / 2;
            int partY = (m + n + 1) / 2 - partX;

            int leftX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int rightX = (partX == m) ? Integer.MAX_VALUE : nums1[partX];

            int leftY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int rightY = (partY == n) ? Integer.MAX_VALUE : nums2[partY];

            if (leftX <= rightY && leftY <= rightX) {
                // Found correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return Math.max(leftX, leftY);
                }
            } else if (leftX > rightY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        throw new IllegalArgumentException("Arrays are not sorted properly");
    }
}
