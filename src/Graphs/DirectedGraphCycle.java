package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int inDegree[] = new int[V];
        for(int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;

            for(int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return count != V;
    }
}
