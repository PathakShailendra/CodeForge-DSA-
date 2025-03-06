package BinarySearch;

public class KokoEatingBananas {
    static int calcHour(int piles[], int mid){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += (int) Math.ceil((double) piles[i] / mid);
        }
        return total;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            if(pile > high)high = pile;
        }
        while(low < high){
            int mid = (low+high)/2;
            int totalHour = calcHour(piles, mid);
            if(totalHour <= h){
                high = mid;
            }
            else low = mid+1;
        }
        return low;
    }
}
