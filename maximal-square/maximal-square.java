class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j]-'0';
                }else{
                    if(matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return max == Integer.MIN_VALUE ? 0 : max * max;
    }
}