package BackTracking;

import java.util.Stack;

public class SortStackUsingRecursion {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop();
            sort(s);
            insertInSortedOrder(s, temp);
        }
        return s;
    }

    private void insertInSortedOrder(Stack<Integer> s, int element) {
        if (s.isEmpty() || s.peek() <= element) {
            s.push(element);
        } else {
            int temp = s.pop();
            insertInSortedOrder(s, element);
            s.push(temp);
        }
    }
}
