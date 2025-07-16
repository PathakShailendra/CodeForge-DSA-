package DynamicProgramming.DPOnLIS;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] dp1 = new int[n]; // LIS
        int[] dp2 = new int[n]; // LDS

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }


        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }


        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
            }
        }

        return maxLen;
    }
}
