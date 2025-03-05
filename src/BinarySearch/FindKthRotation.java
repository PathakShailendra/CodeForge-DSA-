package BinarySearch;

import java.util.List;

public class FindKthRotation {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int start = 0;
        int end = arr.size()-1;
        while(start < end) {
            int mid = (start+end)/2;
            if(arr.get(mid) > arr.get(end)) start = mid+1;
            else end = mid;
        }
        return start;
    }
}
