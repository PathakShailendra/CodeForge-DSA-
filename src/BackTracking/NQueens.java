package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public boolean isValid(int m[][],int r , int c){
        int x = r, y = c;
        //left
        while(y >= 0){
            if(m[x][y] == 1)
                return false;
            y--;
        }

        x=r;
        y=c;

        //up diagonal check
        while(x >= 0 && y >= 0){
            if(m[x][y] == 1)
                return false;
            x--;
            y--;
        }

        x=r;
        y=c;
        //down diagonal
        while(x<m.length && y>=0){
            if(m[x][y] == 1)
                return false;
            x++;
            y--;
        }
        return true;
    }
    public void solve(int m[][], List<List<String>> ans, int c, int n) {
        if(c==n){
            List<String> t = new ArrayList<>();
            for(int i=0; i<n; i++){
                String s = "";
                for(int j=0; j<n; j++){
                    if(m[i][j] == 1)
                        s += 'Q';
                    else
                        s += '.';
                }
                t.add(s);
            }
            ans.add(t);
            return;
        }
        for(int i=0; i<n; i++){
            if(isValid(m,i,c)){
                m[i][c] = 1;
                solve(m,ans,c+1,n);
                m[i][c] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int m[][] = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        solve(m,ans,0,n);
        return ans;
    }
}
