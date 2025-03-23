package BackTracking;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) return;

        int temp = s.pop();
        reverse(s);
        insertAtBottom(s, temp);
    }

    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, element);
        stack.push(temp);
    }
}
