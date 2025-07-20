package DynamicProgramming.DPOnPartition;

public class BooleanExpressionTab {
    static int countWays(String s) {
        int n = s.length();
        int[][] dpTrue = new int[n][n];
        int[][] dpFalse = new int[n][n];

        // Base Case: Single symbols
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) == 'T') {
                dpTrue[i][i] = 1;
                dpFalse[i][i] = 0;
            } else {
                dpTrue[i][i] = 0;
                dpFalse[i][i] = 1;
            }
        }

        // Criss-crossed loop
        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = i + 2; j < n; j += 2) {
                dpTrue[i][j] = 0;
                dpFalse[i][j] = 0;

                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);

                    int lt = dpTrue[i][k - 1];
                    int lf = dpFalse[i][k - 1];
                    int rt = dpTrue[k + 1][j];
                    int rf = dpFalse[k + 1][j];

                    if (op == '&') {
                        dpTrue[i][j] += lt * rt;
                        dpFalse[i][j] += lt * rf + lf * rt + lf * rf;
                    } else if (op == '|') {
                        dpTrue[i][j] += lt * rt + lt * rf + lf * rt;
                        dpFalse[i][j] += lf * rf;
                    } else if (op == '^') {
                        dpTrue[i][j] += lt * rf + lf * rt;
                        dpFalse[i][j] += lt * rt + lf * rf;
                    }
                }
            }
        }

        return dpTrue[0][n - 1];
    }
}
