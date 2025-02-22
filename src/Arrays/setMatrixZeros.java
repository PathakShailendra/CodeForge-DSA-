package Arrays;

public class setMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean [][] flag = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    flag[i][j] = true;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(flag[i][j]) {
                    for(int row = 0; row < n; row++) {
                        matrix[row][j] = 0;
                    }
                    for(int col = 0; col < m; col++) {
                        matrix[i][col] = 0;
                    }
                }
            }
        }
    }
}
