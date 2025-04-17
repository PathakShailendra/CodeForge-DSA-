package HeapsAndPriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // Frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int card : hand) {
            freqMap.put(card, freqMap.getOrDefault(card, 0) + 1);
        }

        // Min Heap to always get the smallest available card
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqMap.keySet());

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek(); // Start of the group

            // Try to form a group of groupSize starting from 'first'
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!freqMap.containsKey(card)) {
                    return false;
                }
                freqMap.put(card, freqMap.get(card) - 1);
                if (freqMap.get(card) == 0) {
                    freqMap.remove(card);
                    // Important: remove from heap only when count becomes zero
                    if (card == minHeap.peek()) {
                        minHeap.poll();
                    }
                }
            }
        }
        return true;
    }
}
