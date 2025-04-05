package Stacks;

import java.util.Stack;

public class SumOfSubArrayMinimums {

        public int[] findNextSmaller(int []arr){
            int[] curr = new int[arr.length];
            Stack<Integer> st = new Stack<>();
            for(int i = 0; i < arr.length; i++){
                while(!st.isEmpty() && arr[st.peek()] >= arr[i])
                    st.pop();
                curr[i] = st.isEmpty() ? i+1 : i - st.peek();
                st.push(i);
            }
            return curr;
        }
        public int[] findPrevSmaller(int []arr){
            int[] curr = new int[arr.length];
            Stack<Integer> st = new Stack<>();
            for(int i = arr.length-1; i >= 0; i--){
                while(!st.isEmpty() && arr[st.peek()] > arr[i])
                    st.pop();
                curr[i] = st.isEmpty() ? arr.length-i : st.peek()-i;
                st.push(i);
            }
            return curr;
        }
        public int sumSubarrayMins(int[] arr) {
            int nextSmaller[] = findNextSmaller(arr);
            int prevSmaller[] = findPrevSmaller(arr);
            int mod = 1_000_000_007;
            long ans = 0;
            for(int i = 0; i < arr.length; i++){
                ans = (ans + (long) arr[i]*nextSmaller[i]*prevSmaller[i])%mod;
            }
            return (int)ans;
        }
}
