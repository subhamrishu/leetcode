// class Solution {
//     int memo[][][];
//     int MODULO = 1000000007;
//     public int findPathsHelper(int m, int n, int N, int i, int j) {
//         if (i < 0 || j < 0 || i == m || j == n)
//             return 1;
//         if (N == 0)
//             return 0;
//         if (memo[i][j][N]>= 0){
//             return memo[i][j][N];
//         }
//         return memo[i][j][N] = ((findPathsHelper(m ,n, N-1, i-1, j)+
//                                 findPathsHelper(m, n, N-1, i+1, j))% MODULO+
//                                 (findPathsHelper(m, n, N-1, i, j-1)+
//                                 findPathsHelper(m, n, N-1, i, j+1))% MODULO) % MODULO;
//     }
//     int findPaths(int m, int n, int maxMove, int startRow, int startCol){
//         memo = new int[m][n][maxMove+1];
//         for (int[][] t1: memo){
//             for (int[] t2: t1)
//                 Arrays.fill(t2, -1);
//         }
//         return findPathsHelper(m, n, maxMove, startRow, startCol);
//     }
// }
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
            // System.out.println("step="+step+"\n"+Arrays.deepToString(count)+"\n"+result);
        }
        
        return result;
    }
}