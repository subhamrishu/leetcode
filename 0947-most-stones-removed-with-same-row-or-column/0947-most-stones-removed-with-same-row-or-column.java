class Solution {
    void dfs(int[][] stones, int[] stone, Set<int[]> visited){
        visited.add(stone);
        for (int[] st: stones){
            if (!visited.contains(st)){
                if (stone[0] == st[0] || stone[1] == st[1]){
                    dfs(stones, st, visited);
                }
            }
            
        }
    }
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int count = 0;
        
        for (int[] stone: stones){
            if (!visited.contains(stone)){
                dfs(stones, stone, visited);
                count++;
            }
        }
        return stones.length - count;
    }
}