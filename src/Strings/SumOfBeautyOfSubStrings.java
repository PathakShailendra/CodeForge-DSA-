package Strings;

public class SumOfBeautyOfSubStrings {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for(int j = i; j < n; j++) {
                freq[s.charAt(j)-'a']++;
                ans += getBeauty(freq);
            }
        }
        return ans;
    }
    public int getBeauty(int freq[]) {
        int maxFreq = 0;
        int minFreq = Integer.MAX_VALUE;

        for(int f : freq) {
            if(f > 0) {
                maxFreq = Math.max(maxFreq, f);
                minFreq = Math.min(minFreq, f);
            }
        }
        return maxFreq - minFreq;
    }
}
