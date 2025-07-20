package DynamicProgramming.DPOnPartition;

public class PalindromePartitioningTab {
    public int minCut(String s) {
        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }
        }

        return dp[n - 1];
    }
}
