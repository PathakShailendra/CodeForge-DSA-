package Strings;

import java.util.HashMap;

public class SubstringWithKDistinct {
    int countSubstr(String s, int k) {
        // your code here
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private int atMostKDistinct(String s, int K) {
        if (K == 0) return 0; // If K is 0, no valid substrings
        int left = 0, count = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

            while (freqMap.size() > K) { // Shrink window if distinct characters exceed K
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++; // Move left pointer
            }

            // Count valid substrings ending at `right`
            count += (right - left + 1);
        }

        return count;
    }
}
