class Solution {
    int[][] memo;
    public int helper(int[][] matrix, int i, int j){
        if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if (i == matrix.length-1)
            return matrix[i][j];
        if (memo[i][j] != -101)
            return memo[i][j];
        return memo[i][j] = matrix[i][j] + 
            Math.min(helper(matrix, i+1, j-1), Math.min(helper(matrix, i+1, j+1), helper(matrix, i+1, j)));
    }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(memo[i], -101);
        }
        for (int j = 0; j < n; j++){
            min = Math.min(min, helper(matrix, 0, j));
        }
        return min;
    }
}