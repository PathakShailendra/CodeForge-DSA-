package Graphs;

public class FloodFill {
    public void solve(int[][] image, int sr, int sc, int color, int oldColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = color;
        solve(image, sr - 1, sc, color, oldColor);  // up
        solve(image, sr + 1, sc, color, oldColor);  // down
        solve(image, sr, sc - 1, color, oldColor);  // left
        solve(image, sr, sc + 1, color, oldColor);  // right
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)return image;
        solve(image, sr, sc, color, image[sr][sc]);
        return image;
    }
}
