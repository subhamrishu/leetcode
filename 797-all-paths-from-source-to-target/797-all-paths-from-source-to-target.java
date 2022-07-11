class Solution {
    List<List<Integer>> sol;
    void dfs(int[][] graph, int n, int curr, List<Integer> currPath){
        if (curr == n-1){
            sol.add(new ArrayList(currPath));
            return;
        }
        for(int i = 0; i < graph[curr].length; i++){
            currPath.add(graph[curr][i]);
            dfs(graph, n, graph[curr][i],currPath);
            currPath.remove(currPath.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        sol = new ArrayList();
        // System.out.println(Arrays.deepToString(graph));
        int n = graph.length;
        List<Integer> currPath = new ArrayList();
        currPath.add(0);
        dfs(graph, n, 0, currPath);
        return sol;
    }
}