package Arrays;

import java.util.ArrayList;

public class Unionof2SortedwithDuplicates {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        Integer lastAdded = null;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                if (lastAdded == null || lastAdded != a[i]) {
                    result.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
            } else if (a[i] > b[j]) {
                if (lastAdded == null || lastAdded != b[j]) {
                    result.add(b[j]);
                    lastAdded = b[j];
                }
                j++;
            } else {
                if (lastAdded == null || lastAdded != a[i]) {
                    result.add(a[i]);
                    lastAdded = a[i];
                }
                i++;
                j++;
            }
        }
        while (i < a.length) {
            if (lastAdded == null || lastAdded != a[i]) {
                result.add(a[i]);
                lastAdded = a[i];
            }
            i++;
        }
        while (j < b.length) {
            if (lastAdded == null || lastAdded != b[j]) {
                result.add(b[j]);
                lastAdded = b[j];
            }
            j++;
        }
        return result;
    }
}
