package BinarySearch;

public class NumberOfOccurances {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int start  = 0;
        int end = n-1;
        int ans = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid]  == target){
                int i=mid;
                int j=mid;
                while (i >= 0 && arr[i] == target) i--;
                while (j < n && arr[j] == target) j++;
                ans = j-i-1;
                break;
            }
            else if(arr[mid]>target)end=mid-1;
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}
