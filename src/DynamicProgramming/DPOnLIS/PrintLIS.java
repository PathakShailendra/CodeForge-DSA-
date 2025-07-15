package DynamicProgramming.DPOnLIS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintLIS {
    public ArrayList<Integer> getLIS(int[] arr) {
        int n = arr.length;
        // dp[i][prev+1] = memoized length
        Map<String, List<Integer>> memo = new HashMap<>();

        // Get list of indices
        List<Integer> indexPath = solve(0, -1, arr, memo);

        // Convert indices to actual values
        ArrayList<Integer> result = new ArrayList<>();
        for (int idx : indexPath) {
            result.add(arr[idx]);
        }
        return result;
    }

    private List<Integer> solve(int i, int prevIndex, int[] arr, Map<String, List<Integer>> memo) {
        if (i == arr.length) return new ArrayList<>();

        String key = i + "|" + (prevIndex + 1);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Not take
        List<Integer> notTake = solve(i + 1, prevIndex, arr, memo);

        // Take
        List<Integer> take = new ArrayList<>();
        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            take.add(i); // store index, not value
            take.addAll(solve(i + 1, i, arr, memo));
        }

        List<Integer> result;
        if (take.size() > notTake.size()) {
            result = take;
        } else if (take.size() < notTake.size()) {
            result = notTake;
        } else {
            result = isIndexLexSmaller(take, notTake) ? take : notTake;
        }

        memo.put(key, result);
        return result;
    }

    private boolean isIndexLexSmaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);  // compare based on index
            }
        }
        return a.size() < b.size();
    }
}
