package HeapsAndPriorityQueue;

import java.util.PriorityQueue;

class KthLargestElementInStream {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int num : nums){
            add(num);
        }
    }

    public int add(int val) {
        if(pq.size() < k){
            pq.offer(val);
        }
        else if(val > pq.peek()){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
