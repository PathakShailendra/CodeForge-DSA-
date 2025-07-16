package DynamicProgramming.DPOnLIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChainTab {
    private boolean isPredecessor(String s1, String s2) {
        if(s1.length()+1 != s2.length()) return false;

        int i = 0;
        int j = 0;
        boolean skip = false;

        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if(skip) return false;
                skip = true;
                j++;
            }
        }
        return true;
    }


    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
