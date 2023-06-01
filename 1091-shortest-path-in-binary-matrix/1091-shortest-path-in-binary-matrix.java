class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] paths = new int[][] {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1},{1,-1},{1,0},{1,1}};
        LinkedList<int[]> q = new LinkedList<>();
        int n = grid[0].length-1;
        if (grid[0][0] != 0 || grid[n][n] != 0)
            return -1;
        q.add(new int[]{0,0,1});
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            if (curr[0] == n && curr[1] == n){
                min = Math.min(min, curr[2]);
            }
            for (int i = 0; i<8; i++){
                int x = curr[0] + paths[i][0];
                int y = curr[1] + paths[i][1];
                if (x <= n && y <= n && x >= 0 && y >= 0 && grid[x][y] != 1){
                    q.add(new int[]{x,y, curr[2]+1});
                    grid[x][y] = 1;
                    
                }
            }
            
        }
        return (min == Integer.MAX_VALUE)? -1 : min;
    }
}