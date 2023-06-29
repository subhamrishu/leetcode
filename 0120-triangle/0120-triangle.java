class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[m][m+1];
        int min = Integer.MAX_VALUE;
        dp[0][0] = dp[0][1] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++){
            for (int j = 0; j <= i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], (j-1 < 0)?Integer.MAX_VALUE: dp[i-1][j-1]);
                if (i == m-1)
                    min = Math.min(min, dp[i][j]);
            }
            dp[i][i+1] = dp[i][i]; 
        }
        return min;
    }
}