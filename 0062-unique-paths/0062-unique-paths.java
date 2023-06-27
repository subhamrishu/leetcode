class Solution {
    int[][] memo;
    int helper(int m, int n){
        if (m == 0 && n == 0)
            return 1;
        else if (m < 0 || n < 0)
            return 0;
        if (memo[m][n] != 0)
            return memo[m][n];
        return memo[m][n] = helper(m-1, n) + helper(m, n-1);
    }
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(m-1, n-1);
    }
}