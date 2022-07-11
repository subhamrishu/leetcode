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
    void bfs(List<List<Integer>> rooms, boolean[] visited, int curr){
        Queue<Integer> q =  new LinkedList();
        q.add(curr);
        
        while(q.size()!=0){
            curr = q.poll();
            visited[curr] = true;
            for(int room: rooms.get(curr)){
                if(!visited[room]){
                    q.offer(room);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n  = rooms.size();
        boolean[] visited = new boolean[n];
        // dfs(rooms, visited, 0);
        bfs(rooms, visited, 0);
        for (int i = 0; i < n; i++)
            if (!visited[i])
                return false;
        return true;
    }
}