package math;

import java.util.ArrayList;
import java.util.Collections;

public class kthFactor {
    public int kthFactorofnum(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                list.add(i);
                if(i != n / i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
        return list.size() >= k ? list.get(k-1) : -1;
    }
}
