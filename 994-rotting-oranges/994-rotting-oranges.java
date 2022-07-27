class Solution {
    int dir[] = {-1, 0, 1, 0, -1};

    void helper(int[][] grid, int x, int y, int val){
        int r = grid.length, c = grid[0].length;
        
        if (grid[x][y] == 1) 
            grid[x][y] = val+1;
        else 
            grid[x][y] = Math.min(val+1, grid[x][y]);
        for (int i = 0; i < 4; i++){
            int xx = x + dir[i];
            int yy = y + dir[i+1];
            if (xx >=0 && xx < r && yy >= 0 && yy < c && grid[xx][yy]!=0 && grid[xx][yy]!=2 && (grid[xx][yy] == 1 || grid[xx][yy] > grid[x][y]+1)){
                helper(grid, xx, yy, grid[x][y]);
            }
        }
        // max = Math.max(max, grid[x][y]);
    }
    public int orangesRotting(int[][] grid) {
        
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                if (grid[i][j] == 2)
                    helper(grid, i, j, 2);
            }
        }
        int min = 2;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                if (grid[i][j] == 1)
                    return -1;
                min = Math.max(min, grid[i][j]);
            }
        }
        return min-2;
    }
}