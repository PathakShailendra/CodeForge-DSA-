package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void generateSubsets(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);

        //pick
        generateSubsets(nums, i + 1, curr, ans);

        curr.remove(curr.size() - 1);

        //notpick
        generateSubsets(nums, i + 1, curr, ans);
    }
}
