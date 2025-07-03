package DynamicProgramming;

import java.util.ArrayList;

public class HouseRobberII {
    public int solve(ArrayList<Integer> nums) {
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            int take = nums.get(i);
            if(i > 1) take += prev2;
            int notTake = 0 + prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(i != 0) list1.add(nums[i]);
            if(i != nums.length-1) list2.add(nums[i]);
        }
        return Math.max(solve(list1), solve(list2));
    }
}
