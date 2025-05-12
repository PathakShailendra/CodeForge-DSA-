package Graphs;

import java.util.*;

public class WordLadderIITLE {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> dict = new HashSet<>(wordList);
            List<List<String>> result = new ArrayList<>();

            if (!dict.contains(endWord)) return result;

            // Step 1: Build graph using BFS
            Map<String, List<String>> graph = new HashMap<>();
            Map<String, Integer> level = new HashMap<>();
            bfs(beginWord, endWord, dict, graph, level);

            // Step 2: Backtrack using DFS to find all paths
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, graph, level, path, result);

            return result;
        }

        private void bfs(String beginWord, String endWord, Set<String> dict,
                         Map<String, List<String>> graph, Map<String, Integer> level) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            level.put(beginWord, 0);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean foundEnd = false;

                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    int currLevel = level.get(word);
                    char[] chars = word.toCharArray();

                    for (int j = 0; j < chars.length; j++) {
                        char original = chars[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) continue;
                            chars[j] = c;
                            String nextWord = new String(chars);

                            if (dict.contains(nextWord)) {
                                // Build graph
                                graph.computeIfAbsent(word, k -> new ArrayList<>()).add(nextWord);
                                if (!level.containsKey(nextWord)) {
                                    level.put(nextWord, currLevel + 1);
                                    queue.offer(nextWord);
                                }
                            }
                        }
                        chars[j] = original;
                    }
                }
            }
        }

        private void dfs(String word, String endWord, Map<String, List<String>> graph,
                         Map<String, Integer> level, List<String> path, List<List<String>> result) {
            if (word.equals(endWord)) {
                result.add(new ArrayList<>(path));
                return;
            }

            if (!graph.containsKey(word)) return;

            for (String next : graph.get(word)) {
                if (level.get(next) == level.get(word) + 1) {
                    path.add(next);
                    dfs(next, endWord, graph, level, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
}
