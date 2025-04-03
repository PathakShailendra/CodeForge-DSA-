package Stacks;

import java.util.Stack;

public class GreaterElementsToRight {
    public int[] countGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove all smaller elements (they won’t contribute)
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }

            // Stack size gives the count of greater elements
            result[i] = st.size();

            // Push current element into stack
            st.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        GreaterElementsToRight obj = new GreaterElementsToRight();
        int[] nums = {3, 4, 9, 6, 1};  // Example input
        int[] result = obj.countGreaterElements(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
