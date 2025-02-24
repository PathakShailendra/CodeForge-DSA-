package ArraysHard;

import java.util.ArrayList;

public class missingAndRepeating {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int repeating = -1;
        int missing = -1;
        for(int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i])-1;
            if(arr[index] < 0) {
                repeating = Math.abs(arr[i]);
            }
            else {
                arr[index] = -arr[index];
            }
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                missing = i+1;
                break;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(repeating);
        res.add(missing);
        return res;
    }
}
