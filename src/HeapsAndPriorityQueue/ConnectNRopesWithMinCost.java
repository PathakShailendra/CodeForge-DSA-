package HeapsAndPriorityQueue;

import java.util.PriorityQueue;

public class ConnectNRopesWithMinCost {
    public static int minCost(int[] arr) {
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.add(rope);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println(minCost(ropes));
    }
}
