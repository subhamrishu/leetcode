class Solution {
    int MODULO = 1000000007;
    Integer[][][] dp;
    public int findPaths_helper(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n)
            return 1;
        if (maxMove == 0)
            return 0;
        if (dp[startRow][startColumn][maxMove] != null)
            return dp[startRow][startColumn][maxMove];
        int sum  = 0;
        sum = (sum + findPaths_helper(m,n,maxMove-1, startRow-1, startColumn)) % MODULO;
        sum = (sum + findPaths_helper(m,n,maxMove-1, startRow+1, startColumn)) % MODULO;
        sum = (sum + findPaths_helper(m,n,maxMove-1, startRow, startColumn-1)) % MODULO;
        sum = (sum + findPaths_helper(m,n,maxMove-1, startRow, startColumn+1)) % MODULO;
        return dp[startRow][startColumn][maxMove] = sum;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove+1];
        return findPaths_helper(m,n,maxMove,startRow,startColumn);
    }
}