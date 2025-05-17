package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindEventualSafeNodes {
    public static boolean dfs(int node, int[][] graph, HashMap<Integer, Boolean> map){
        if(map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node, false);
        for(int n : graph[node]){
            if(!dfs(n, graph, map)){
                return false;
            }
        }
        map.put(node, true);
        return true;
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dfs(i,graph,map)) {
                res.add(i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> res = eventualSafeNodes(graph);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
