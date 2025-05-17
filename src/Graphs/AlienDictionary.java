package Graphs;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String[] words) {
        // Step 1: Create a graph and in-degree map
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Step 2: Initialize graph with all unique characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new ArrayList<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }

        // Step 3: Build edges based on the order of words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Check for invalid prefix case
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; // Invalid case
            }

            // Find the first different character and add the edge
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }

        // Step 4: Topological Sort (Kahn's Algorithm)
        Queue<Character> q = new LinkedList<>();
        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);

            for (char nei : graph.get(ch)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) {
                    q.offer(nei);
                }
            }
        }

        // Step 5: Check for cycle
        if (sb.length() != inDegree.size()) {
            return ""; // Cycle exists
        }

        return sb.toString();
    }
}
