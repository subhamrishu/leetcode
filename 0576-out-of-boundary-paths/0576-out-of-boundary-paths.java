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
        // dp = new Integer[m][n][maxMove+1];
        // return findPaths_helper(m,n,maxMove,startRow,startColumn);
        
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        
        int count = 0;
        
        for (int i = 1; i <= maxMove; i++){
            int[][] temp = new int[m][n];
            for (int j = 0; j < m; j++){
                for (int k = 0; k < n; k++){
                    if (j == 0) 
                        count = (count + dp[j][k]) % MODULO;
                    if (j == m-1) 
                        count = (count + dp[j][k]) % MODULO;
                    if (k == 0) 
                        count = (count + dp[j][k]) % MODULO;
                    if (k == n-1) 
                        count = (count + dp[j][k]) % MODULO;
                    
                    temp[j][k] = (temp[j][k] + ((j > 0) ? dp[j-1][k]: 0))% MODULO;
                    temp[j][k] = (temp[j][k] + ((j < m-1) ? dp[j+1][k]: 0)) % MODULO;
                    temp[j][k] = (temp[j][k] + ((k > 0) ? dp[j][k-1]: 0)) % MODULO;
                    temp[j][k] = (temp[j][k] + ((k < n-1) ? dp[j][k+1]: 0) )% MODULO;
                }
            }
            dp = temp;
        }
        return count;
    }
}