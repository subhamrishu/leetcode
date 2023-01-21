class Solution {
    void dfs(char[][] mat, int r, int c, int x, int y){
        mat[x][y] = '2';
        // System.out.println(x + " " + y);
        int dir[] = {-1, 0, 1, 0, -1};
        boolean flag = false;
        for (int i = 0; i<4; i++){
            int x1 = x + dir[i], y1 = y + dir[i+1];
            // System.out.println("Outside" + x1 + " " + y1);
            if (x1 < r && x1 >=0 && y1 < c && y1 >=0 && mat[x1][y1] == '1'){
                // System.out.println("Inside" + x1 + " " + y1);
                dfs(mat, r, c, x1, y1);
                // flag=true;
            }
        }
        // return flag;
    }
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;
        int numOfIslands = 0;
        
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, row, col, i, j);
                    numOfIslands += 1;
                    // System.out.println(Arrays.deepToString(grid));
                    // System.out.println("\n");
                }
            }
        }
        
        return numOfIslands;
    }
}