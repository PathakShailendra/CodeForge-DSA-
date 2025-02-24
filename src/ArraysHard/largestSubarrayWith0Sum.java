package ArraysHard;

import java.util.HashMap;

public class largestSubarrayWith0Sum {

        int maxLen(int arr[]) {
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,-1);
            int sum = 0;
            int maxLength = 0;
            for(int i = 0; i < arr.length;i++){
                sum += arr[i];
                if(map.containsKey(sum)){
                    int length = i-map.get(sum);
                    maxLength = Math.max(maxLength,length);
                }
                else{
                    map.put(sum,i);
                }
            }
            return maxLength;
    }
}
