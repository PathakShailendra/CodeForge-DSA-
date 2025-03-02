package Sorting;

public class QuickSort {

        // Function to sort an array using quick sort algorithm.
        static void quickSort(int arr[], int low, int high) {
            // code here
            if (low < high) {
                int pivotIndex = partition(arr, low, high);  // Find pivot position

                quickSort(arr, low, pivotIndex - 1);  // Left part
                quickSort(arr, pivotIndex + 1, high);  // Right part
            }
        }

        static int partition(int arr[], int low, int high) {
            // your code here
            int pivot = arr[high];  // Last element as pivot
            int i = low - 1;  // Pointer for smaller element

            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {  // If current element is smaller than pivot
                    i++;
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Swap arr[i+1] and pivot
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            return i + 1;
        }

}
