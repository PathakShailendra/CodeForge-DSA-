package Arrays;

import java.util.TreeSet;

public class longestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int count = 1;
        int prev = set.first();
        int max = 1;
        for(int val : set) {
            if(prev+1 == val) {
                count++;
            }else {
                count = 1;
            }
            max = Math.max(max, count);
            prev = val;
        }
        return max;
    }
}
