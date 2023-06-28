class Solution {
//     int[][] memo;
//     int helper(int i, int j, int[][] grid){
//         if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
//             return 0;
//         else if (i == grid.length-1 && j == grid[0].length-1)
//             return 1;
        
//         else if (memo[i][j] != -1)
//             return memo[i][j];
//         return memo[i][j] = helper(i+1, j, grid) + helper(i, j+1, grid);
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length, n = obstacleGrid[0].length;
//         memo = new int[m][n];
//         for (int i = 0; i < m; i++)
//             Arrays.fill(memo[i], -1);
//         return helper(0,0,obstacleGrid);
//     }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1)
            return 0;
        
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                break;
            }
            else
                dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                break;
            }else
                dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}