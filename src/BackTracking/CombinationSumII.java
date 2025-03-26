package BackTracking;

import java.util.*;

public class CombinationSumII {
    public void solve(int arr[], int i, int target, List<Integer> curr, Set<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue;

            curr.add(arr[j]);
            solve(arr, j + 1, target - arr[j], curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>();
        solve(candidates, 0, target, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
}
