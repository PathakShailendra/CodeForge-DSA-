package Stacks;

import java.util.Stack;

public class PrefixToInfixUsingStack {
    static String preToInfix(String prefix) {
        // code here
        Stack<String> stack = new Stack<>();
        int n = prefix.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + c + op2 + ")";
                stack.push(temp);
            }
        }
        return stack.peek();
    }
}
