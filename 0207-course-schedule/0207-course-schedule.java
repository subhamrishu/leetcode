class Solution {
    int dfs(int currNode, boolean[] visited, boolean[] safeNodes, List<List<Integer>> graph){
        visited[currNode] = true;
        
        int sum = 0;
        for (int node: graph.get(currNode)){
            if (safeNodes[node])
                sum += 1;
            else if (!visited[node])
                sum += dfs(node, visited, safeNodes, graph);
            if (sum == 0)
                break;
        }
        if (sum == graph.get(currNode).size()){
            safeNodes[currNode] = true;
            return 1;
        }
        return 0;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] node: prerequisites){
            graph.get(node[0]).add(node[1]);
        }
        boolean[] safeNodes = new boolean[n];
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < graph.size(); i++){
            if (!visited[i])
                dfs(i, visited, safeNodes, graph);
        }
        int sum = 0;
        for (int i = 0; i< n; i++){
            if (safeNodes[i]) sum++;
        }
        return sum == numCourses;
    }
}