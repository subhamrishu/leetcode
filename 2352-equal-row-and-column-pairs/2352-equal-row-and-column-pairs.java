class Solution {
    public int equalPairs(int[][] grid) {
        Map<Long, Integer> map = new HashMap<>();
        int sol = 0;
        for (int i = 0; i < grid.length; i++){
            long sum = 0;
            for (int j = 0; j < grid[0].length; j++){
                sum = sum *10 + grid[i][j];
            }
            map.putIfAbsent(sum, 0);
            map.put(sum, map.get(sum)+1);
        }
        for (int i = 0; i < grid.length; i++){
            long sum = 0;
            for (int j = 0; j < grid[0].length; j++){
                sum = sum *10 + grid[j][i];
            }
            sol += map.getOrDefault(sum,0);
        }
        return sol;
    }
}