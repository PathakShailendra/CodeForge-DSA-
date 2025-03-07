package BinarySearch;

public class CapacityToShipPackagesInDDays {
    static int findDays(int arr[], int capacity){
        int count = 1; int load = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + load > capacity){
                count++;
                load = arr[i];
            }
            else load += arr[i];
        }
        return count;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = weights[0];
        for(int i = 1; i < weights.length; i++){
            low = Math.max(weights[i] , low);
            high += weights[i];
        }
        while(low <= high){
            int mid = low+(high-low)/2;
            int noOfDays = findDays(weights, mid);
            if(noOfDays <= days){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}
