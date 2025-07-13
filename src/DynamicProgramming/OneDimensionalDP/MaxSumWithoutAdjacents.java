package DynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class MaxSumWithoutAdjacents {
    private int helper(int i, int[] arr, int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return arr[i];
        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + helper(i-2, arr, dp);
        int notPick = helper(i-1, arr, dp);

        return dp[i] = Math.max(pick, notPick);
    }


    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        return helper(n-1, arr, dp);
    }
}
