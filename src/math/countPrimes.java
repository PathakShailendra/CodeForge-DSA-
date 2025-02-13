package math;

import java.util.Arrays;

public class countPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        int count=0;
        for(int i=2; i<=Math.sqrt(n) ; i++){
            if(isPrime[i]){
                for(int j=i*2 ; j<n ; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=2; i<n ; i++){
            if(isPrime[i]) count++;
        }
        return count;
    }
}
