package Graph;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class FloodFillProblem {
    public static void dfs(int row,int col,int[][] ans,int[][] image,int newColor,int[] delRow,int[] delCol,int initialColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        //Traverse all the neighbor row and col in 4 direction
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol <m && image[nrow][ncol]==initialColor && ans[nrow][ncol]!=newColor){
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,initialColor);
            }
        }
    }
    public static int[][] floodfill(int[][] image,int sr,int sc,int newColor){
        int initialColor = image[sr][sc];
        int[][] ans = image;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,+1,0,-1};
        dfs(sr,sc,ans,image,newColor,delRow,delCol,initialColor);
        return ans;
    }
    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] ans = floodfill(image,sr,sc,newColor);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
