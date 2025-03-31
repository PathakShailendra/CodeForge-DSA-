package Stacks;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0)return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if(st.isEmpty()){
                return false;
            }
            else {
                if(ch == ')' && st.peek() != '('){
                    return false;
                }
                else if(ch == '}' && st.peek() != '{'){
                    return false;
                }
                else if(ch == ']' && st.peek() != '['){
                    return false;
                }
                else{
                    st.pop();
                }
            }
        }
        return st.size() == 0;
    }
}
