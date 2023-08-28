class Solution {
    public int equalPairs(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int sol = 0;
        for(int i = 0; i < grid.length; i++){
            String hash = "";
            for (int j = 0; j < grid[0].length; j++){
                hash += "*"+grid[i][j];
            }
            int hashKey = hash.hashCode();
            map.putIfAbsent(hashKey, 0);
            map.put(hashKey, map.get(hashKey)+1);
        }
        for(int i = 0; i < grid.length; i++){
            String hash = "";
            for (int j = 0; j < grid[0].length; j++){
                hash += "*"+grid[j][i];
            }
            
            sol += map.getOrDefault(hash.hashCode(), 0);
        }
        return sol;
    }
}