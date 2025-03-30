package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblem {

    private boolean backtrack(int node, int v, int m, List<List<Integer>> graph, int[] color) {

        if (node == v) return true;


        for (int c = 1; c <= m; c++) {
            if (isValid(node, c, graph, color)) {
                color[node] = c;
                if (backtrack(node + 1, v, m, graph, color)) return true; // Recur
                color[node] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int node, int c, List<List<Integer>> graph, int[] color) {

        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == c) return false;
        }
        return true;
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        int[] color = new int[v];


        return backtrack(0, v, m, graph, color);
    }
}
