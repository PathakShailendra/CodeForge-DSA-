package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

public class RatInaMazeI {
    public void findPaths(int r, int c, ArrayList<ArrayList<Integer>> mat, int n,
                          String path, ArrayList<String> ans) {

        if (r < 0 || c < 0 || r >= n || c >= n || mat.get(r).get(c) == 0) {
            return;
        }


        if (r == n - 1 && c == n - 1) {
            ans.add(path);
            return;
        }


        mat.get(r).set(c, 0);

        // Move Down
        findPaths(r + 1, c, mat, n, path + "D", ans);
        // Move Left
        findPaths(r, c - 1, mat, n, path + "L", ans);
        // Move Right
        findPaths(r, c + 1, mat, n, path + "R", ans);
        // Move Up
        findPaths(r - 1, c, mat, n, path + "U", ans);


        mat.get(r).set(c, 1);
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();


        if (mat.get(0).get(0) == 0) {
            return ans;
        }


        findPaths(0, 0, mat, n, "", ans);


        Collections.sort(ans);

        return ans;
    }
}
