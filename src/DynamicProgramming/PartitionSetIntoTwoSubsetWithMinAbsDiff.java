package DynamicProgramming;

public class PartitionSetIntoTwoSubsetWithMinAbsDiff {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int elem : nums) totalSum += elem;
        int k = totalSum;

        boolean [][]dp = new boolean[n][totalSum+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] <= totalSum) dp[0][nums[0]] = true;

        for(int idx = 1; idx < n; idx++) {
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[idx-1][target];
                boolean take = false;
                if(nums[idx] < target) take = dp[idx-1][target-nums[idx]];
                dp[idx][target] = take || notTake;
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int s1 = 0; s1 <= totalSum/2; s1++) {
            if(dp[n-1][s1]) {
                int s2 = totalSum - s1;
                mini = Math.min(mini, Math.abs(s1-s2));
            }
        }
        return mini;
    }

    // this code gives me the ArrayOutOfBoundException for leetcode problem 2035
    // but this code is correct
}
