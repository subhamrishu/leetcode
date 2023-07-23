class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int freshCount = 0;
        int m = grid.length, n= grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2)
                    rotten.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        if (freshCount == 0) return 0;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        int count = 0;
        while (!rotten.isEmpty()){
            count++;
            for (int k = rotten.size(); k > 0; k--){
                int[] curr = rotten.poll();
                for (int i = 0; i < 4; i++){
                    int x = curr[0] + dir[i];
                    int y = curr[1] + dir[i+1];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    rotten.add(new int[]{x, y});
                    freshCount--;
                }
            }
        }
        // System.out.println(Arrays.deepToString(grid));
        return freshCount == 0? count - 1: -1;
    }
}