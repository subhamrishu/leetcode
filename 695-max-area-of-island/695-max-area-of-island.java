class Solution {
    int dir[] = {-1, 0, 1, 0, -1};
    int dfs(int[][] grid, int i, int j){
        int r = grid.length;
        int c = grid[0].length;
        grid[i][j] = 0;
        int count = 1;
        for (int k = 0; k < 4; k++){
            int x = i + dir[k];
            int y = j + dir[k+1];
            if (x >=0 && x < r && y >=0 && y < c && grid[x][y] == 1)
                count+= dfs(grid, x, y);
        }
        return count;
    } 
    public int maxAreaOfIsland(int[][] grid) {
        int maxNumOfIslands = 0;
        for (int i = 0; i < grid.length; i++){
            // int currIsland = 0;
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1)
                    maxNumOfIslands = Math.max(maxNumOfIslands, dfs(grid, i, j));       
            }
        }
        return maxNumOfIslands;
    }
}