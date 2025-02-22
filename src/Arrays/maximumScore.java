package Arrays;

public class maximumScore {
    public int pairWithMaxSum(int arr[]) {
        int n = arr.length;
        if (n < 2) return -1; // Minimum 2 elements hone chahiye

        int maxSum = Integer.MIN_VALUE;

        // Iterate through the array and find adjacent pair sum
        for (int i = 0; i < n - 1; i++) {
            int pairSum = arr[i] + arr[i + 1];
            maxSum = Math.max(maxSum, pairSum);
        }

        return maxSum;
    }
}
