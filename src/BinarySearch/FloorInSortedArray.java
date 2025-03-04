package BinarySearch;

public class FloorInSortedArray {
    static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int floorIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                floorIndex = mid;  // Don't return immediately
                low = mid + 1;  // Keep searching for the last occurrence
            }
            else if (arr[mid] < x) {
                floorIndex = mid;  // Update potential floor
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return floorIndex;
    }
}
