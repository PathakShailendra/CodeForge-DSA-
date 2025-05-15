package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int dest = pair[0];
            int src = pair[1];
            adj.get(src).add(dest);
            indegree[dest]++;
        }

        // Step 2: Add all nodes with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                q.add(i);

        // Step 3: Perform BFS and build topological order
        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result[index++] = curr;

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                    q.add(neighbor);
            }
        }

        // Step 4: Check if topological sort is possible
        if (index == numCourses)
            return result;
        else
            return new int[0]; // cycle exists
    }
}
