package Arrays;

public class sortedArraySearch {
    static boolean searchInSorted(int arr[], int k) {
        // Your code here
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == k)return true;
            if(arr[mid] < k){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}
