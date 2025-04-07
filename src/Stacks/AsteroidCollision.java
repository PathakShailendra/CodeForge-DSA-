package Stacks;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if (asteroids[i] > 0)
                st.push(asteroids[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])) {
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() == Math.abs(asteroids[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                }
            }
        }
        int ans[] = new int[st.size()];
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }
        int i = 0;
        while(!temp.isEmpty()){
            ans[i++] = temp.pop();
        }
        return ans;
    }
}
