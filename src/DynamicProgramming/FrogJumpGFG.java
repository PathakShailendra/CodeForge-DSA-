package DynamicProgramming;

import java.util.Arrays;

public class FrogJumpGFG {
    int helper(int i, int[] height, int[] dp) {
        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];

        int oneJump = helper(i - 1, height, dp) + Math.abs(height[i] - height[i - 1]);
        int twoJump = Integer.MAX_VALUE;

        if(i > 1) {
            twoJump = helper(i - 2, height, dp) + Math.abs(height[i] - height[i - 2]);
        }

        return dp[i] = Math.min(oneJump, twoJump);
    }

    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(n - 1, height, dp);
    }

}
