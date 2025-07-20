package DynamicProgramming.DPOnPartition;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, arr, k, dp);
    }

    private int solve(int i, int[] arr, int k, int[] dp) {
        int n = arr.length;
        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];

        int maxInPartition = Integer.MIN_VALUE;
        int len = 0;
        int maxSum = 0;

        for (int j = i; j < Math.min(i + k, n); j++) {
            len++;
            maxInPartition = Math.max(maxInPartition, arr[j]);
            int sum = (len * maxInPartition) + solve(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }
}
