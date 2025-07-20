package DynamicProgramming.DPOnPartition;

public class PalindromePartitioning {
    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static int[][] dp;

    static int f(int i, int n, String str) {
        if (i == n) return 0;

        if (dp[i][n] != -1) return dp[i][n];

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + f(j + 1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i][n] = minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return f(0, n, s) - 1;
    }
}
