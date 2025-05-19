package Graphs.ShortestPathAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            int len = current[2];

            if (row == n - 1 && col == n - 1) return len;

            for (int i = 0; i < 8; i++) {
                int newRow = row + dx[i];
                int newCol = col + dy[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol, len + 1});
                }
            }
        }

        return -1;
    }
}
