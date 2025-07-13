package DynamicProgramming.DPOnSubsequences;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int count(int nums[], int target, int i, Map<String, Integer> memo){
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        String key = i + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = count(nums, target - nums[i], i + 1, memo);
        int sub = count(nums, target + nums[i], i + 1, memo);

        memo.put(key, add + sub);
        return add + sub;

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<String, Integer> memo = new HashMap<>();
        return count(nums, target , 0, memo);

    }
}
