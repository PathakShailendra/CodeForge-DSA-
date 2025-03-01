package Sorting;

public class InsertionSort {
    public void insertionSort(int arr[]) {
        // code here
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Pick the current element
            int j = i - 1;

            // Shift elements that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key at its correct position
            arr[j + 1] = key;
        }
    }
}
