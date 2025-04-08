package Queues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];

        int n = nums.length;
        int []res = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peekFirst() < i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i >= k-1){
                res[i-k+1] = nums[dq.peekFirst()];

            }
        }
        return res;
    }
}
