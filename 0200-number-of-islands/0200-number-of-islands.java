class Solution {
    public void dfs(int i, int j, char[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '2' || grid[i][j] == '0')
            return;
        grid[i][j] = '2';
        dfs(i, j+1, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i-1, j, grid);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    count += 1;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
}