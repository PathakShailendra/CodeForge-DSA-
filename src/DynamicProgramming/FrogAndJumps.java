package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class FrogAndJumps {
    public int unvisitedLeaves(int n, int leaves, int frogs[]) {
        // Code here
        boolean[] visited = new boolean[leaves + 1];
        Set<Integer> seen = new HashSet<>(); // To avoid duplicate strengths

        for (int i = 0; i < n; i++) {
            int k = frogs[i];
            if (k <= leaves && !seen.contains(k)) {
                seen.add(k);
                for (int j = k; j <= leaves; j += k) {
                    visited[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= leaves; i++) {
            if (!visited[i]) count++;
        }

        return count;
    }
}
