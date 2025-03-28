package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    ArrayList<String> list = new ArrayList<>();
    public static String[] keypad = {".", ".", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void printComb(String str, int i, String combination){
        if (i == str.length()){
            if(!combination.isEmpty())
                list.add(combination);
            return;
        }
        char currChar = str.charAt(i);
        String mapping = keypad[currChar - '0'];

        for (int j = 0; j < mapping.length(); j++){
            printComb(str, i+1, combination+mapping.charAt(j));
        }
    }
    public List<String> letterCombinations(String digits) {
        printComb(digits, 0 , "");
        return list;
    }
}
