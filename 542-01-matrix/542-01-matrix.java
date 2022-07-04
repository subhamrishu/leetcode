class Solution {
    

    public int[][] updateMatrix(int[][] mat) {
        int[] xy = {-1, 0, 1, 0, -1};
        int row = mat.length, col = mat[0].length;
        Queue<int[]> q = new LinkedList();
        for (int i=0; i<row; i++){
            for(int j = 0; j<col; j++){
                if (mat[i][j] == 1)
                    mat[i][j] = -1;
                else
                    q.offer(new int[] {i,j});
            }
        }
        
        while (q.size() > 0){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int i = 0; i<4; i++){
                int rr = r + xy[i], cc = c + xy[i+1];
                if (rr < 0 || rr == row || cc < 0 || cc == col || mat[rr][cc] != -1)
                    continue;
                mat[rr][cc] = mat[r][c] + 1;
                q.offer(new int[] {rr, cc});
            }
        }
        return mat;
    }
}