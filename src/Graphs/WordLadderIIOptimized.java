package Graphs;

import java.util.*;

public class WordLadderIIOptimized {

        private List<List<String>> results = new ArrayList<>();
        private Map<String, List<String>> graph = new HashMap<>();
        private Map<String, Integer> distance = new HashMap<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return results;

            bfs(beginWord, endWord, wordSet);
            List<String> path = new ArrayList<>();
            dfs(endWord, beginWord, path);
            return results;
        }

        private void bfs(String beginWord, String endWord, Set<String> wordSet) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            distance.put(beginWord, 0);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean foundEnd = false;

                for (int i = 0; i < size; i++) {
                    String currentWord = queue.poll();
                    int currentDistance = distance.get(currentWord);
                    List<String> neighbors = getNeighbors(currentWord, wordSet);

                    for (String neighbor : neighbors) {
                        graph.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(currentWord);
                        if (!distance.containsKey(neighbor)) {
                            distance.put(neighbor, currentDistance + 1);
                            if (neighbor.equals(endWord)) {
                                foundEnd = true;
                            } else {
                                queue.offer(neighbor);
                            }
                        }
                    }
                }

                if (foundEnd) break;
            }
        }

        private List<String> getNeighbors(String word, Set<String> wordSet) {
            List<String> neighbors = new ArrayList<>();
            char[] chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }

                chars[i] = originalChar;
            }

            return neighbors;
        }

        private void dfs(String currentWord, String beginWord, List<String> path) {
            path.add(currentWord);
            if (currentWord.equals(beginWord)) {
                List<String> validPath = new ArrayList<>(path);
                Collections.reverse(validPath);
                results.add(validPath);
            } else {
                List<String> predecessors = graph.get(currentWord);
                if (predecessors != null) {
                    for (String predecessor : predecessors) {
                        if (distance.get(predecessor) + 1 == distance.get(currentWord)) {
                            dfs(predecessor, beginWord, path);
                        }
                    }
                }
            }
            path.remove(path.size() - 1);
        }
}
