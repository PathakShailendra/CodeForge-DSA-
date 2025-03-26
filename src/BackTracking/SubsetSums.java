package BackTracking;

import java.util.ArrayList;

public class SubsetSums {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        generateAllSub(arr, 0, 0, ans);
        return ans;
    }

    private void generateAllSub(int[] arr, int i, int sum, ArrayList<Integer> ans) {
        if(i == arr.length) {
            ans.add(sum);
            return;
        }
        generateAllSub(arr, i+1, sum+arr[i], ans);
        generateAllSub(arr, i+1, sum, ans);
    }
}
