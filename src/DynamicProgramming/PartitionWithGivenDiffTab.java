package DynamicProgramming;

public class PartitionWithGivenDiffTab {
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int mod = 1000000007;
        int totalSum = 0;

        for(int num : arr) totalSum += num;

        // Check if target is valid
        if(totalSum < d || (totalSum + d) % 2 != 0) return 0;

        int target = (totalSum + d) / 2;

        int[][] dp = new int[n][target + 1];

        // Base Case
        if(arr[0] == 0) {
            dp[0][0] = 2;  // { }, {0}
        } else {
            dp[0][0] = 1;  // {}
            if(arr[0] <= target) dp[0][arr[0]] = 1;
        }

        for(int idx = 1; idx < n; idx++) {
            for(int t = 0; t <= target; t++) {
                int notTake = dp[idx-1][t];
                int take = 0;
                if(arr[idx] <= t) {
                    take = dp[idx-1][t - arr[idx]];
                }
                dp[idx][t] = (take + notTake) % mod;
            }
        }

        return dp[n-1][target];
    }
}
