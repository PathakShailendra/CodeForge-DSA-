package DynamicProgramming.DPOnSubsequences;

public class SubsetSumProblemTab {
    static Boolean isSubsetSum(int arr[], int sum) {

        // code here
        int N = arr.length;
        boolean[][] dp = new boolean[N][sum + 1];


        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < N; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (arr[i] <= target) {
                    pick = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = pick || notPick;
            }
        }

        return dp[N - 1][sum];
    }
}
