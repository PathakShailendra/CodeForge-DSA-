package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;

        int maxLength = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, set.size());
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
