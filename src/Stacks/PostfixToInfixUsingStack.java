package Stacks;

import java.util.Stack;

public class PostfixToInfixUsingStack {
    static String postToInfix(String postfix) {
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
                String temp = "(" + op1 + c + op2 + ")"; // Infix format with brackets
                stack.push(temp);
            }
        }

        return stack.peek();
    }
}
