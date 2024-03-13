class Solution {
    int[] dir = new int[]{-1, 0, 1, 0, -1};
    void bfs(char[][] grid, int i, int j, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '2';
        q.add(new int[]{i, j});
        while (!q.isEmpty()){
            int[] curr = q.poll();
            // grid[curr[0]][curr[1]] = '2';
            for (int k = 0; k < 4; k++){
                int x = curr[0] + dir[k];
                int y = curr[1] + dir[k+1];
                if (x < m && x >=0 && y<n && y>=0 && grid[x][y] == '1'){
                    q.add(new int[]{x, y});
                    grid[x][y] = '2';
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    islands++;
                    bfs(grid, i, j, m, n);
                }
            }
        }
        return islands;
    }
}