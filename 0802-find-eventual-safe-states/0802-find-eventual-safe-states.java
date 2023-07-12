class Solution {
    int dfs(int currNode, boolean[] visited, Set<Integer> sol, int[][] graph){
        visited[currNode] = true;
        if (graph[currNode].length == 0){
            sol.add(currNode);
            return 1;
        }
        int sum = 0;
        for (int node: graph[currNode]){
            if (sol.contains(node))
                sum += 1;
            else if (!visited[node])
                sum += dfs(node, visited, sol, graph);
        }
        if (sum == graph[currNode].length){
            sol.add(currNode);
            return 1;
        }
        return 0;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < graph.length; i++){
            if (!visited[i])
                dfs(i, visited, set, graph);
        }
        List<Integer> sol = new ArrayList<>(set);
        Collections.sort(sol);
        return sol;
    }
}