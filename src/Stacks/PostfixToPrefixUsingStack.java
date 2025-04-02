package Stacks;

import java.util.Stack;

public class PostfixToPrefixUsingStack {
    static String postToPre(String postfix) {
        // code here
        Stack<String> stack = new Stack<>();
        int n = postfix.length();

        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                String temp = c + op1 + op2; // Prefix format
                stack.push(temp);
            }
        }

        return stack.peek();
    }
}
