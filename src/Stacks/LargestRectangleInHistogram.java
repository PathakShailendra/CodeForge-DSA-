package Stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] NSR = new int[n];
        int[] NSL = new int[n];

        Stack<Integer> stack = new Stack<>();

        //NSR
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = n;
            } else {
                NSR[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        //NSL
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
