class Solution {
    int dfs(List<Integer>[] graph, int[] informTime, int u){
        int timeOfNode = 0;
        for (int v: graph[u]){
            timeOfNode = Math.max(timeOfNode, dfs(graph, informTime, v));
        }
        return timeOfNode+informTime[u];
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++){
            if(i != headID){
                graph[manager[i]].add(i);
            }
        }
        return dfs(graph, informTime, headID);
    }
}