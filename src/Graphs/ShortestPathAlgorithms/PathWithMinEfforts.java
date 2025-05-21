package Graphs.ShortestPathAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEfforts {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int[][] effort = new int[n][m];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        effort[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == n - 1 && y == m - 1) return currEffort;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
                    int diff = Math.abs(heights[x][y] - heights[newX][newY]);
                    int maxEffort = Math.max(currEffort, diff);

                    if (effort[newX][newY] > maxEffort) {
                        effort[newX][newY] = maxEffort;
                        pq.add(new int[]{maxEffort, newX, newY});
                    }
                }
            }
        }

        return 0;
    }
}
