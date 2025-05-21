package Graphs.ShortestPathAlgorithms;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Graph creation
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>())
                    .add(new int[]{flight[1], flight[2]}); // to, price
        }

        // Step 2: Min-Heap PriorityQueue: [cost, city, stops]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0}); // cost, city, stops

        // Step 3: Cost array for tracking min stops
        int[] stopsVisited = new int[n];
        Arrays.fill(stopsVisited, Integer.MAX_VALUE);
        stopsVisited[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            // If destination reached
            if (city == dst) return cost;

            // If we can still make a stop
            if (stops > k) continue;

            // Visit all neighbours
            if (graph.containsKey(city)) {
                for (int[] neighbour : graph.get(city)) {
                    int nextCity = neighbour[0];
                    int price = neighbour[1];

                    // Only push if fewer stops or cheaper cost
                    if (stops + 1 <= k + 1 && stopsVisited[nextCity] > stops) {
                        pq.add(new int[]{cost + price, nextCity, stops + 1});
                        stopsVisited[nextCity] = stops;
                    }
                }
            }
        }

        return -1; // No valid path found
    }
}
