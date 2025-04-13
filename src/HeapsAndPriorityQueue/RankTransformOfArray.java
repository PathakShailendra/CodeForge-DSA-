package HeapsAndPriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
        }

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        while (!pq.isEmpty()) {
            int val = pq.poll();
            if (!rankMap.containsKey(val)) {
                rankMap.put(val, rank++);
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
