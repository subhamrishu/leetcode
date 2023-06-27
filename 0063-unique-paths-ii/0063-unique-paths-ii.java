class Solution {
    int[][] memo;
    int helper(int i, int j, int[][] grid){
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return 0;
        else if (i == grid.length-1 && j == grid[0].length-1)
            return 1;
        
        else if (memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = helper(i+1, j, grid) + helper(i, j+1, grid);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
        return helper(0,0,obstacleGrid);
    }
}