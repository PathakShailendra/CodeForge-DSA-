package BackTracking;

import java.util.HashSet;

public class BetterString {

        public static String betterString(String s1, String s2) {
            HashSet<String> set1 = new HashSet<>();
            generateAllSub(set1, "", s1, 0);
            set1.remove(""); // Remove empty subsequence

            HashSet<String> set2 = new HashSet<>();
            generateAllSub(set2, "", s2, 0);
            set2.remove(""); // Remove empty subsequence

            return set1.size() >= set2.size() ? s1 : s2;
        }

        private static void generateAllSub(HashSet<String> set, String curr, String s, int i) {
            if (i == s.length()) {
                set.add(curr);
                return;
            }
            generateAllSub(set, curr + s.charAt(i), s, i + 1);
            generateAllSub(set, curr, s, i + 1);
        }

        public static void main(String[] args) {
            System.out.println(betterString("gfg", "ggg")); // Expected Output: "gfg"
        }

}
