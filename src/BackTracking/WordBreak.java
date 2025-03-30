package BackTracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s, wordDict, memo);
    }

    public boolean helper(String s, List<String> wordDict, Map<String, Boolean> memo){
        if(s.isEmpty()) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for(int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if(wordDict.contains(prefix) && helper(s.substring(i), wordDict, memo)){
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
