package DynamicProgramming.DPOnPartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutStick {
        public static int f(int i, int j, List<Integer> cuts) {
            if (i > j) return 0;

            int mini = Integer.MAX_VALUE;

            for (int ind = i; ind <= j; ind++) {
                int cost = cuts.get(j + 1) - cuts.get(i - 1)
                        + f(i, ind - 1, cuts)
                        + f(ind + 1, j, cuts);
                mini = Math.min(mini, cost);
            }

            return mini;
        }
        public int minCost(int n, int[] cutsArray) {
            List<Integer> cuts = new ArrayList<>();
            for (int cut : cutsArray) {
                cuts.add(cut);
            }

            cuts.add(n); // push_back(n)
            cuts.add(0); // insert 0 at beginning
            Collections.sort(cuts);

            return f(1, cuts.size() - 2, cuts);
        }
}
