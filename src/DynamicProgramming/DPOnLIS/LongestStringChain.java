package DynamicProgramming.DPOnLIS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public class Solution {
        Map<String, Integer> memo = new HashMap<>();

        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));

            int maxLen = 1;

            for (String word : words) {
                maxLen = Math.max(maxLen, dfs(word, words));
            }

            return maxLen;
        }

        private int dfs(String currentWord, String[] words) {
            if (memo.containsKey(currentWord)) return memo.get(currentWord);

            int maxLength = 1;

            for (String prevWord : words) {
                if (prevWord.length() + 1 < currentWord.length()) continue;
                if (prevWord.length() + 1 > currentWord.length()) break;

                if (isPredecessor(prevWord, currentWord)) {
                    int currLength = 1 + dfs(prevWord, words);
                    maxLength = Math.max(maxLength, currLength);
                }
            }

            memo.put(currentWord, maxLength);
            return maxLength;
        }

        private boolean isPredecessor(String word1, String word2) {
            if (word1.length() + 1 != word2.length()) return false;

            int i = 0, j = 0;
            boolean skipped = false;

            while (i < word1.length() && j < word2.length()) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (skipped) return false;
                    skipped = true;
                    j++;
                }
            }

            return true;
        }
    }

}
