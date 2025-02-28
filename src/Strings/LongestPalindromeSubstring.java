package Strings;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0; // To track the longest palindrome's position

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);  // Even-length palindrome
            int len = Math.max(len1, len2);  // Get the maximum palindrome length

            if (len > end - start) {  // Update start & end if a longer palindrome is found
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;  // Length of the palindrome found
    }
}
