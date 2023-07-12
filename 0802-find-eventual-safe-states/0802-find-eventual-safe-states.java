class Solution {
    int dfs(int currNode, boolean[] visited, boolean[] safeNodes, int[][] graph){
        visited[currNode] = true;
        
        int sum = 0;
        for (int node: graph[currNode]){
            if (safeNodes[node])
                sum += 1;
            else if (!visited[node])
                sum += dfs(node, visited, safeNodes, graph);
            if (sum == 0)
                break;
        }
        if (sum == graph[currNode].length){
            safeNodes[currNode] = true;
            return 1;
        }
        return 0;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> set = new HashSet<>();
        boolean[] safeNodes = new boolean[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < graph.length; i++){
            if (!visited[i])
                dfs(i, visited, safeNodes, graph);
        }
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i< n; i++){
            if (safeNodes[i]) sol.add(i);
        }
        return sol;
    }
}