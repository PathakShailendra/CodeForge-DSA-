package Strings;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder part = new StringBuilder();
        for(char str : s.toCharArray()){
            part.append(str);
            if(str == '(')count++;
            else count--;
            if(count == 0){
                result.append(part.substring(1,part.length()-1));
                part.setLength(0);
            }
        }
        return result.toString();
    }
}
