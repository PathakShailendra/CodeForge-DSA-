package HeapsAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
        }
        while(k != 1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}
