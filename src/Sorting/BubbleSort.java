package Sorting;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        // code here
        int n = arr.length;
        boolean swapped; // Optimized check

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for swapping adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Agar koi swapping nahi hui toh array already sorted hai
            if (!swapped) break;

        }
    }
}
