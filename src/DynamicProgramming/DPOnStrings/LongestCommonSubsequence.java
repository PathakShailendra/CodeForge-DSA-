package DynamicProgramming.DPOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private int solve(int i, int j, String s1, String s2, int [][]dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + solve(i-1, j-1, s1, s2, dp);
        }

        return dp[i][j] = Math.max(solve(i-1, j, s1, s2, dp), solve(i, j-1, s1, s2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length()-1;
        int j = text2.length()-1;

        int [][]dp = new int[i+1][j+1];
        for(int []arr : dp) Arrays.fill(arr, -1);
        return solve(i, j, text1, text2, dp);
    }
}
