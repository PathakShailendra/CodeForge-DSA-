package DynamicProgramming.DPOnLIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    private int solve(int i, int prev, int []nums, int [][]dp) {
        if(i == nums.length) return 0;

        if(dp[i][prev+1] != -1) return dp[i][prev+1];

        int notTake = solve(i+1, prev, nums, dp);

        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(i+1, i, nums, dp);
        }

        return dp[i][prev+1] = Math.max(take, notTake);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n][n+1];


        for(int []arr : dp) Arrays.fill(arr, -1);
        return solve(0, -1, nums, dp);
    }
}
