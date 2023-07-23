class Solution {
    boolean dfs(int curr, List<List<Integer>> graph, int[] visited, List<Integer> sol){
        if (visited[curr] == 2) return true;
        if (visited[curr] == 1) return false;
        visited[curr] = 1;
        for(int k = 0; k < graph.get(curr).size(); k++){
            if (!dfs(graph.get(curr).get(k), graph, visited, sol)) return false;
        }
        visited[curr] = 2;
        sol.add(curr);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] d: prerequisites){
            graph.get(d[0]).add(d[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            visited[i] = 0;
        }
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i, graph, visited, sol)) return new int[0];
        }
        // if (sol.size() != numCourses){
        //     ;
        // }
        int[] res = new int[numCourses];
        for (int i= 0; i < sol.size(); i++){
            res[i] = sol.get(i);
        }
        return res;
    }
}