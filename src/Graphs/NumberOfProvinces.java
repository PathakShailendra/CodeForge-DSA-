package Graphs;

import java.util.ArrayList;

public class NumberOfProvinces {
    public void dfs(int curr, ArrayList<ArrayList<Integer>> adjLs, boolean[] visited){
        visited[curr] = true;
        for(int temp : adjLs.get(curr)){
            if(!visited[temp]){
                dfs(temp, adjLs, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        int V = isConnected.length;
        for(int i = 0; i < V; i++){
            adjLs.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int provinces = 0;
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, adjLs, visited);
            }
        }
        return provinces;
    }
}
