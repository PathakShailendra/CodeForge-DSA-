package SlidingWindow;

import java.util.HashMap;

public class SubStringContainingAllThreeChar {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.size() == 3){
                ans += (n-i);
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar,0)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
        }
        return ans;
    }
}
