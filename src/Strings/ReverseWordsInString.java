package Strings;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length-1; i >= 0; i--) {
            String curr = words[i];
            if(curr.equals(""))continue;
            String ans = curr.trim();
            sb.append(ans + " ");
        }
        return sb.toString().trim();
    }
}
