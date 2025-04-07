package Stacks;

import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(!st.isEmpty() && k > 0 && (st.peek()-'0') > (num.charAt(i)-'0')){
                st.pop();
                k -= 1;
            }
            st.push(num.charAt(i));
        }
        while(k > 0){
            st.pop();
            k -= 1;
        }
        if(st.isEmpty())return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        while (sb.length() != 0 && sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length() == 0)return "0";
        sb.reverse();
        return sb.toString();
    }
}