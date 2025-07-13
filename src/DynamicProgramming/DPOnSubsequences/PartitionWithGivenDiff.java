package DynamicProgramming.DPOnSubsequences;

public class PartitionWithGivenDiff {
    int mod = 1000000007;

    public int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // Check if valid partition possible
        if ((totalSum + d) % 2 != 0 || totalSum < d) return 0;

        int target = (totalSum + d) / 2;

        Integer[][] dp = new Integer[n][target + 1];
        return countSubsets(n - 1, target, arr, dp);
    }

    private int countSubsets(int index, int target, int[] arr, Integer[][] dp) {
        // Base case
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2; // pick or not pick 0
            if (target == 0 || arr[0] == target) return 1;
            return 0;
        }

        if (dp[index][target] != null) return dp[index][target];

        int notTake = countSubsets(index - 1, target, arr, dp);
        int take = 0;
        if (arr[index] <= target)
            take = countSubsets(index - 1, target - arr[index], arr, dp);

        return dp[index][target] = (take + notTake) % mod;
    }
}
