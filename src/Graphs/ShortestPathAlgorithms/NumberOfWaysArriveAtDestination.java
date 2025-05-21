package Graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Step 1: Graph Create karo
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        // Step 2: Distance and Ways array
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        // Step 3: Min-Heap (distance, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});  // {distance, node}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int node = current[1];

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeTime = neighbor[1];

                if (time + edgeTime < dist[nextNode]) {
                    dist[nextNode] = time + edgeTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new int[]{dist[nextNode], nextNode});
                } else if (time + edgeTime == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
