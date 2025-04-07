package Stacks;

import java.util.Stack;

class SumOfSubArrayRanges {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;

        Stack<Integer> st = new Stack<>();

        // Contribution as maximum
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                res += (long) nums[mid] * left * right;
            }
            st.push(i);
        }

        st.clear();

        // Contribution as minimum
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? mid + 1 : mid - st.peek();
                int right = i - mid;
                res -= (long) nums[mid] * left * right;
            }
            st.push(i);
        }

        return res;
    }
}
