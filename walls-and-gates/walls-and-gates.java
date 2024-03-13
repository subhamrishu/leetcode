class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q =new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }

        int[] dir = new int[]{-1, 0, 1, 0, -1};
        while (!q.isEmpty()){
            int[] t = q.poll();
            
            for (int i = 0; i < 4; i++){
                int x = t[0] + dir[i];
                int y = t[1] + dir[i+1];
                if (x < m && x >= 0 && y < n && y >= 0 && rooms[x][y] == EMPTY){
                    q.offer(new int[]{x, y});
                    rooms[x][y] = rooms[t[0]][t[1]] + 1;
              }
            }
        }
        return ;
    }
}