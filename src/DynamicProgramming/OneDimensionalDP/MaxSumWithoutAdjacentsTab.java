package DynamicProgramming.OneDimensionalDP;

public class MaxSumWithoutAdjacentsTab {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            int take = arr[i];
            if(i > 1) {
                take += dp[i-2];
            }
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[n-1];
    }
}
