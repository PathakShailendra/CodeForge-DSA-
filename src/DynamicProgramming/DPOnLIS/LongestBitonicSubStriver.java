package DynamicProgramming.DPOnLIS;

import java.util.Arrays;

public class LongestBitonicSubStriver {
    public static int LongestBitonicSequence(int n, int[] nums) {
        // code here
        int []dp1 = new int[n];
        int []dp2 = new int [n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j > i; j--) {
                if(nums[i] > nums[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                }
            }
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
        }
        return maxLen;
    }
}
