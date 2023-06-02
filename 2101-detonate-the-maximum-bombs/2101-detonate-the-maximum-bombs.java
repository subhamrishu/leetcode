class Solution {
    public int maximumDetonation(int[][] bombs) {
        int maxCount = 1;
        int n = bombs.length;
        
        for (int i = 0; i < n; i++){
            maxCount = Math.max(maxCount, dfs(bombs, i, new boolean[n]));
        }
        return maxCount;
    }
    private int dfs(int[][] bombs, int x, boolean[] visited){
        int count = 0;
        visited[x] = true;
        for (int i = 0; i < bombs.length; i++){
            if(!visited[i] && inRange(x, i, bombs)){
                count += dfs(bombs, i, visited);
            }
        }
        return 1+count;
    }
    private boolean inRange(int i, int j, int[][] bombs){
        long dx = bombs[i][0] - bombs[j][0];
        long dy = bombs[i][1] - bombs[j][1];
        long r1 = bombs[i][2];
        return dx*dx + dy*dy <= r1*r1;
    }
}