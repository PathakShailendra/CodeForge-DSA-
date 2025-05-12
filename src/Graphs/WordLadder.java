package Graphs;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // Step 1: If endWord not in wordList, return 0
        if (!wordSet.contains(endWord)) return 0;

        // Step 2: BFS initialization
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        // Step 3: BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all words at current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArr = word.toCharArray();

                // Try changing every character
                for (int j = 0; j < wordArr.length; j++) {
                    char originalChar = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        if (newWord.equals(endWord)) {
                            return level + 1; // Found the endWord
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Avoid revisiting
                        }
                    }

                    wordArr[j] = originalChar; // Backtrack
                }
            }

            level++; // Go to next level
        }

        return 0; // No possible transformation
    }
}

