package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubSetsII {
    public void generateSubsets(int arr[], int i, List<Integer> curr, HashSet<List<Integer>> set){
        if(i == arr.length){
            set.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[i]);
        // include
        generateSubsets(arr, i+1, curr, set);

        curr.remove(curr.size()-1);
        //exclude
        generateSubsets(arr, i+1, curr, set);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        generateSubsets(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }
}
