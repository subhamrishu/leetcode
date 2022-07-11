class Solution {
    void dfs(List<List<Integer>> rooms, boolean[] visited, int curr){
        // if(visited[curr])
        //     return;
        visited[curr] = true;
        int n = rooms.get(curr).size();
        for(int i: rooms.get(curr)){
            if(!visited[i]){
                dfs(rooms, visited, i);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n  = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (int i = 0; i < n; i++)
            if (!visited[i])
                return false;
        return true;
    }
}