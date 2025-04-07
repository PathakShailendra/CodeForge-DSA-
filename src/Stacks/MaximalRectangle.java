package Stacks;

import java.util.Stack;

public class MaximalRectangle {
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
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int maxArea = 0;
        int pSum[][] = new int[m][n];
        for(int j = 0; j < n; j++){
            int sum = 0;
            for(int i = 0; i < m; i++){
                if(matrix[i][j] == '1')sum += 1;
                else sum = 0;
                pSum[i][j] = sum;
            }
        }
        for(int i = 0; i < m; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(pSum[i]));
        }
        return maxArea;
    }
}
