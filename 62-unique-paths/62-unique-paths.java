class Solution {
    // int sol = 0;
    /* Recursive with memo solution - 0ms
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
    */
    public int uniquePaths(int m, int n) {
        // dp = new Integer[m][n];
        // return dfs(0, 0, m-1, n-1);
        int[] first = new int[n];
        int[] second = new int[n];
        second[0]=1;
        for (int i = 0; i < m; i++){
            for (int j = 1; j<n; j++){
                second[j] = first[j] + second[j-1]; 
            }
            first = second;
            second = new int[n];
            second[0] = 1;
        }
        return first[n-1];
    }
}