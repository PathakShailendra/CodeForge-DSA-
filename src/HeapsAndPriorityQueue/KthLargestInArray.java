package HeapsAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
