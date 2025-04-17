package HeapsAndPriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class Pair implements Comparable<Pair>{
        int key;
        int val;
        public Pair(int key, int val){
            this.key = key;
            this.val = val;
        }

        public int compareTo(Pair P2){
            return this.val > P2.val ? 1 : -1;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.offer(new Pair(key, map.get(key)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            res[i++] = curr.key;
        }
        return res;
    }
}
