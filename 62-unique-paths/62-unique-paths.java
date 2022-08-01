class Solution {
    // int sol = 0;
    Integer[][] dp;
    int dfs(int i, int j, int m, int n){
        if (i == m && j == n){
            return 1;
        }
        if (i > m || j > n)
            return 0;
        if (dp[i][j]!=null)
            return dp[i][j];
        return dp[i][j] = dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    }
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return dfs(0, 0, m-1, n-1);
    }
}