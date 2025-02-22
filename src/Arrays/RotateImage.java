package Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int i = 0;
        int j = matrix.length-1;
        int [][]arr = new int[matrix.length][matrix.length];
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix[x].length; y++){
                arr[i][j] = matrix[x][y];
                if(y == matrix[x].length-1){
                    i = 0;
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        for(int x = 0; x < matrix.length; x++){
            for(int y = 0; y < matrix.length; y++){
                matrix[x][y] = arr[x][y];
            }
        }
    }
}
