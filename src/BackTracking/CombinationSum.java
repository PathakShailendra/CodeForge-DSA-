package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public void solve(int arr[], int i, int target , List<Integer> curr, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0){
            return;
        }

        for(int j = i; j < arr.length; j++){
            curr.add(arr[j]);
            solve(arr, j, target-arr[j], curr, ans);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
}
