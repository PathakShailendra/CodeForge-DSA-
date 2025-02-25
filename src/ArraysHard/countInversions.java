package ArraysHard;

public class countInversions {
    class Solution {
        static int mergeAndCount(int arr[], int temp[], int left, int mid, int right) {
            int i = left;     // Left subarray index
            int j = mid + 1;  // Right subarray index
            int k = left;     // Temp array index
            int invCount = 0;

            while (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                    invCount += (mid - i + 1); // All elements in left subarray are greater than arr[j]
                }
            }

            while (i <= mid) temp[k++] = arr[i++];
            while (j <= right) temp[k++] = arr[j++];

            for (i = left; i <= right; i++) arr[i] = temp[i];

            return invCount;
        }

        static int mergeSortAndCount(int arr[], int temp[], int left, int right) {
            int invCount = 0;
            if (left < right) {
                int mid = (left + right) / 2;

                invCount += mergeSortAndCount(arr, temp, left, mid);
                invCount += mergeSortAndCount(arr, temp, mid + 1, right);
                invCount += mergeAndCount(arr, temp, left, mid, right);
            }
            return invCount;
        }
        static int inversionCount(int arr[]) {
            int n = arr.length;
            int temp[] = new int[n];
            return mergeSortAndCount(arr, temp, 0, n - 1);
        }
    }
}
