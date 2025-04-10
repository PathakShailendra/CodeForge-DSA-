package SlidingWindow;

import java.util.HashMap;

public class SubarrayWithKDiffIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int TT = 0;
        for(int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
            while(map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            TT += right-left+1;
        }
        return TT;
    }
}
