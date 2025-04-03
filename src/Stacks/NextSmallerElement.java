package Stacks;

import java.util.Stack;

public class NextSmallerElement {
    public int[] nextSmallerElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] < st.peek()) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextSmallerElement obj = new NextSmallerElement();
        int[] nums = {4, 8, 5, 2, 25};
        int[] result = obj.nextSmallerElement(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
