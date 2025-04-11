package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int minStart = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) >= 0)count++;
            }

            while(count == t.length()){
                if(minLength > i-start+1){
                    minLength = i-start+1;
                    minStart = start;
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start))>0)count--;
                }
                start++;
            }
        }
        if(minLength > s.length())return "";
        return s.substring(minStart, minStart+minLength);
    }
}
