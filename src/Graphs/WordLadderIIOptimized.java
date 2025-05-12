package Graphs;

import com.sun.tools.javac.Main;

import java.awt.*;
import java.util.*;
import java.util.List;

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

/*
Dono codes ka goal same hai: **Find all shortest transformation sequences** from `beginWord` to `endWord`, where each transformation changes only one character and all intermediate words must exist in the given `wordList`.

Lekin dono mein approach ka **direction** aur **optimization level** thoda different hai. Chalo step by step difference dekhte hain:

        ---

        ## ✅ **
Main Differences**

        ### 🔁 **1. Direction of DFS Traversal**

        #### ✅ Optimized Code:

        * DFS traversal **backward** ho raha hai (`dfs(endWord, beginWord, path)`), i.e. from `endWord` to `beginWord`.
        * `graph` is built with **edges pointing to predecessors**, i.e. `graph.get(currentWord)` returns previous words.
* Isse jab DFS karte ho toh `Collections.reverse()` se final path create hota hai.

        #### ❌ Non-Optimized Code:

        * DFS traversal **forward** ho raha hai (`dfs(beginWord, endWord, ...)`).
        * `graph` is built with **edges pointing to next words**, i.e. `graph.get(word)` gives next possible transformations.

        ---

        ### ⚙️ **2. Graph Representation**

        #### ✅ Optimized Code:

        * `graph` stores **backward links** → `currentWord -> List of previousWords`.
        * This means during DFS we only go backward using these stored predecessors.

        #### ❌ Non-Optimized Code:

        * `graph` stores **forward links** → `currentWord -> List of nextWords`.

        ---

        ### ⏱️ **3. Early Termination in BFS**

        #### ✅ Optimized Code:

        * Uses a `foundEnd` flag in BFS: **as soon as `endWord` is found, break** the BFS loop.
* This avoids unnecessary traversal and makes it faster.

        #### ❌ Non-Optimized Code:

        * No early stopping. BFS continues until all levels are processed even after `endWord` is found.
        * **Slower**, because extra levels get traversed unnecessarily.

        ---

        ### 🧠 **4. Memory Optimization**

        #### ✅ Optimized Code:

        * Stores only **distance and predecessor info**.
        * DFS uses `if (distance.get(predecessor) + 1 == distance.get(currentWord))` to ensure shortest path.

        #### ❌ Non-Optimized Code:

        * `graph` stores all neighbors even if they’re **not on the shortest path**.
        * DFS needs to **check levels** to avoid wrong paths.

        ---

        ### 💡 **5. DFS Entry Point**

        #### ✅ Optimized Code:

        * DFS starts from `endWord`, goes backward using predecessors till `beginWord`.

        #### ❌ Non-Optimized Code:

        * DFS starts from `beginWord`, goes forward using next words till `endWord`.

        ---

        ## 🔚 Final Outcome

Dono solutions **correct results** denge — lekin:

        | Feature                  | Optimized Code                | Non-Optimized Code            |
        | ------------------------ | ----------------------------- | ----------------------------- |
        | BFS Graph Direction      | backward (to predecessors)    | forward (to next words)       |
        | DFS Direction            | from `endWord` to `beginWord` | from `beginWord` to `endWord` |
        | Early Stop in BFS        | ✅ Yes                         | ❌ No                          |
        | Graph Size (space usage) | Smaller                       | Slightly larger               |
        | DFS Conditions           | More efficient                | Needs extra level checks      |
        | Speed                    | ⚡ Faster                      | 🐢 Slower (in large cases)    |

        ---

Agar tumse interview ya coding round mein poocha jaye, toh optimized code is **more efficient** because it avoids redundant paths, uses early exit, and does clean BFS+DFS separation.

Kya tum chahte ho mein iska dry run bhi karke dikhaun with some example?


 */