package HeapsAndPriorityQueue;

import java.util.*;

public class MaximumSumCombination {
    static class Pair {
        int sum, i, j;
        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        Set<String> visited = new HashSet<>();

        int i = N - 1;
        int j = N - 1;
        maxHeap.add(new Pair(A[i] + B[j], i, j));
        visited.add(i + "_" + j);

        ArrayList<Integer> result = new ArrayList<>();

        while (K-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            // next pair (i-1, j)
            if (current.i - 1 >= 0) {
                String key1 = (current.i - 1) + "_" + current.j;
                if (!visited.contains(key1)) {
                    maxHeap.add(new Pair(A[current.i - 1] + B[current.j], current.i - 1, current.j));
                    visited.add(key1);
                }
            }

            // next pair (i, j-1)
            if (current.j - 1 >= 0) {
                String key2 = current.i + "_" + (current.j - 1);
                if (!visited.contains(key2)) {
                    maxHeap.add(new Pair(A[current.i] + B[current.j - 1], current.i, current.j - 1));
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}
