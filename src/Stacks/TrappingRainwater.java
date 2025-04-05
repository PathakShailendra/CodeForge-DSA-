package Stacks;

import java.util.Stack;

public class TrappingRainwater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;
        int n = height.length;

        for (int i = 0; i < n; i++) {
            // While current bar is higher than the top of the stack
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop(); // Bottom of the container

                if (stack.isEmpty()) break; // No left boundary

                int left = stack.peek(); // Left boundary
                int width = i - left - 1;
                int boundedHeight = Math.min(height[i], height[left]) - height[bottom];

                totalWater += width * boundedHeight;
            }

            stack.push(i);
        }

        return totalWater;
    }
}
