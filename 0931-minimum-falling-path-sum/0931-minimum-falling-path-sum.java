class Solution {
    
    // public int helper(int[][] matrix, int i, int j){
    //     if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0)
    //         return Integer.MAX_VALUE;
    //     if (i == matrix.length-1)
    //         return matrix[i][j];
    //     if (memo[i][j] != -101)
    //         return memo[i][j];
    //     return memo[i][j] = matrix[i][j] + 
    //         Math.min(helper(matrix, i+1, j-1), Math.min(helper(matrix, i+1, j+1), helper(matrix, i+1, j)));
    // }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 0; j < n; j++){
                if (j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if(j == n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], dp[i-1][j]);
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                }
            }
        }
        for (int i = 0; i < n; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}