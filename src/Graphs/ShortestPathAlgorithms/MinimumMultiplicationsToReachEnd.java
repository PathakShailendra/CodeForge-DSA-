package Graphs.ShortestPathAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.steps));

        // Start node
        dist[start] = 0;
        pq.add(new Pair(0, start));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int steps = current.steps;
            int num = current.num;

            // If we reached the target
            if (num == end) return steps;

            // Try all multipliers
            for (int mult : arr) {
                int newNum = (num * mult) % mod;
                if (steps + 1 < dist[newNum]) {
                    dist[newNum] = steps + 1;
                    pq.add(new Pair(steps + 1, newNum));
                }
            }
        }
        return -1; // Not reachable
    }

    class Pair {
        int steps, num;
        Pair(int steps, int num) {
            this.steps = steps;
            this.num = num;
        }
    }
}
