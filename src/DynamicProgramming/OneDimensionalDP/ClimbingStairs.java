package DynamicProgramming.OneDimensionalDP;

import java.util.Arrays;

public class ClimbingStairs {
    public int countWays(int n, int[] dp) {
        if(n == 0)return 1;
        if(n < 0)return 0;
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = countWays(n-1, dp) + countWays(n-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return countWays(n, dp);
    }
}
