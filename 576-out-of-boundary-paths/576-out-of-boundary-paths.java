class Solution {
    int memo[][][];
    int MODULO = 1000000007;
    public int findPathsHelper(int m, int n, int N, int i, int j) {
        if (i < 0 || j < 0 || i == m || j == n)
            return 1;
        if (N == 0)
            return 0;
        if (memo[i][j][N]>= 0){
            return memo[i][j][N];
        }
        return memo[i][j][N] = ((findPathsHelper(m ,n, N-1, i-1, j)+
                                findPathsHelper(m, n, N-1, i+1, j))% MODULO+
                                (findPathsHelper(m, n, N-1, i, j-1)+
                                findPathsHelper(m, n, N-1, i, j+1))% MODULO) % MODULO;
    }
    int findPaths(int m, int n, int maxMove, int startRow, int startCol){
        memo = new int[m][n][maxMove+1];
        for (int[][] t1: memo){
            for (int[] t2: t1)
                Arrays.fill(t2, -1);
        }
        return findPathsHelper(m, n, maxMove, startRow, startCol);
    }
}