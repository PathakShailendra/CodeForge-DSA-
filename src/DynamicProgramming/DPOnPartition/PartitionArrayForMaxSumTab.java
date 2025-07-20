package DynamicProgramming.DPOnPartition;

public class PartitionArrayForMaxSumTab {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxInPartition = Integer.MIN_VALUE;
            int len = 0;

            for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                len++;
                maxInPartition = Math.max(maxInPartition, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + len * maxInPartition);
            }
        }

        return dp[n];
    }
}
