package BinarySearch;

import java.util.Arrays;

public class CeilTheFloor {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        // code here\
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return new int[]{arr[mid], arr[mid]}; // Floor and ceil are the same
            }
            else if (arr[mid] < x) {
                floor = arr[mid];  // Update floor
                low = mid + 1;  // Search right for a larger floor
            }
            else {
                ceil = arr[mid];  // Update ceil
                high = mid - 1;  // Search left for a smaller ceil
            }
        }

        return new int[]{floor, ceil};
    }
}
