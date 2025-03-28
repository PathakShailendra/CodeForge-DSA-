package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int k, int n, int start) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (k == 0 || n < 0) return;

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(result, curr, k - 1, n - i, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
