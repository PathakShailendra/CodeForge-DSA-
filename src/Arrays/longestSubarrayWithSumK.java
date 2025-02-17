package Arrays;

import java.util.HashMap;

public class longestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLen = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If sum equals K, update maxLen
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // If (prefixSum - K) exists, update maxLen
            if (sumIndexMap.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - sumIndexMap.get(prefixSum - k));
            }

            // Store prefixSum if not already stored
            if (!sumIndexMap.containsKey(prefixSum)) {
                sumIndexMap.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
