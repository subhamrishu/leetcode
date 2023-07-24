class Solution {
    boolean dfs(int curr, int target, List<List<Integer>> graph, boolean[] visited){
        if (curr == target)
            return true;
        visited[curr] = true;
        for (int adj: graph.get(curr)){
            if (!visited[adj] && dfs(adj, target, graph, visited))
                return true;
        }
        visited[curr] = false;
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= 1000; i++){
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[1001];
        for (int[] edge: edges){
            
            if (dfs(edge[0], edge[1], graph, visited)){
                return edge;
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return new int[2];
    }
}