package Sorting;

public class MergeSort {
        public static void merge(int arr[], int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int L[] = new int[n1];
            int R[] = new int[n2];

            // Copy data to temporary arrays L[] and R[]
            for (int i = 0; i < n1; i++)
                L[i] = arr[left + i];
            for (int j = 0; j < n2; j++)
                R[j] = arr[mid + 1 + j];

            // Merge the temp arrays back into arr[left...right]
            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of L[] if any
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            // Copy remaining elements of R[] if any
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }



        void mergeSort(int arr[], int l, int r) {
            // code here
            if (l < r) {
                int mid = l + (r - l) / 2;

                mergeSort(arr, l, mid);  // Sort first half
                mergeSort(arr, mid + 1, r);  // Sort second half
                merge(arr, l, mid, r);  // Merge sorted halves
        }
    }
}
