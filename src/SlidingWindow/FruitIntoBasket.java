package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static int totalElements(Integer[] arr) {
        // code here
        int i = 0, j = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (j < arr.length) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;

        }
        return max;
    }
}
