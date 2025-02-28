package Strings;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i = 0;
        int ans = 0;
        while(i < s.length()-1){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))){
                ans += map.get(s.charAt(i));
                i+=1;
            }
            else{
                ans += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i+=2;
            }
        }
        if(i < s.length())ans += map.get(s.charAt(i));
        return ans;
    }
}
