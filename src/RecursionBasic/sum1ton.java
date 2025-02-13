package RecursionBasic;

public class sum1ton {
    int sumOfSeries(int n) {
        // code here
        if(n == 1) {
            return 1;
        }
        int cube = n*n*n;
        return cube + sumOfSeries(n-1);
    }
}
