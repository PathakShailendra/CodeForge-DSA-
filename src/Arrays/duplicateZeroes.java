package Arrays;

public class duplicateZeroes {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0, i = 0;

        // Count total number of elements including duplicate zeros
        for (i = 0; i < n; i++) {
            count++;
            if (arr[i] == 0) count++;
        }

        int j = count - 1; // Position in modified array

        // Traverse from end and shift elements
        for (i = n - 1; i >= 0; i--) {
            if (j < n) arr[j] = arr[i]; // Copy element if within bounds
            j--;

            if (arr[i] == 0) { // If zero, add duplicate zero
                if (j < n) arr[j] = 0;
                j--;
            }
        }
    }
}
