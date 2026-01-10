package Graph;

import java.util.*;

class RottenOranges {
    class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        int tm = 0;
        int count = 0;
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int time = q.peek().time;
            tm = Math.max(time, tm);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }

            }
        }
        //Instead of this we are using countfresh variable
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(vis[i][j]!=2 && grid[i][j]==1){
        //             return -1;
        //         }
        //     }
        // }
        if (count != cntFresh) {
            return -1;
        }
        return tm;
    }

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(ro.orangesRotting(grid));
    }
}
