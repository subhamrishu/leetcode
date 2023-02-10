class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length, c = grid[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j <c ; j++){
                if (grid[i][j] == 1)
                    q.add(new int[]{i,j});
            }
        }
        int count = 0;
        int dir[] = {-1, 0, 1, 0, -1};
        while (q.size() != 0){
            int curr_size = q.size();
            for (int i = 0; i < curr_size; i++){
                int[] curr = q.poll();
                for (int k = 0; k < 4; k++){
                    int x1 = curr[0] + dir[k];
                    int y1 = curr[1] + dir[k+1];
                    if (x1 < r && x1 >=0 && y1 < c && y1 >= 0 && grid[x1][y1] == 0) {
                        grid[x1][y1] = 1;
                        q.add(new int[]{x1, y1});
                    }
                }
            }
            count++;
        }
        return (count-1) == 0 ? -1 : count-1;
    }
}