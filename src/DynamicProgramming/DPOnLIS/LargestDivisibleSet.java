package DynamicProgramming.DPOnLIS;

import java.util.*;

public class LargestDivisibleSet {
    private List<Integer> solve(int i, int prevIndex, int[] nums, Map<String, List<Integer>> memo) {
        if (i == nums.length) return new ArrayList<>();

        String key = i + "|" + (prevIndex + 1);
        if (memo.containsKey(key)) return new ArrayList<>(memo.get(key));

        List<Integer> notTake = solve(i + 1, prevIndex, nums, memo);

        List<Integer> take = new ArrayList<>();
        if (prevIndex == -1 || nums[i] % nums[prevIndex] == 0) {
            take.add(nums[i]);
            take.addAll(solve(i + 1, i, nums, memo));
        }

        List<Integer> result = (take.size() > notTake.size()) ? take : notTake;
        memo.put(key, new ArrayList<>(result));
        return result;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        Map<String, List<Integer>> memo = new HashMap<>();
        return solve(0, -1, nums, memo);
    }
}
