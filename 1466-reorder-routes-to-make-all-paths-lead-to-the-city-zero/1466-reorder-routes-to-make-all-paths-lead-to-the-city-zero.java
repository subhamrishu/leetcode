class Solution {
    int dfs(int currNode, Map<Integer, List<Integer>> adjList, boolean[] visited, 
           Map<Integer, List<Integer>> undirectedAdjList){
        // if (visited[currNode] == 0)
        //     return 0;
        visited[currNode] = true;
        // if (adjList.get(currNode) == null)
        //     return 1;
        int count = 0;
        for (int node: undirectedAdjList.get(currNode)){
            if (visited[node] == false){
                if(adjList.get(currNode) !=null)
                    count += adjList.get(currNode).contains(node) == true ? 1 : 0 ;
                count += dfs(node, adjList, visited, undirectedAdjList);
            }
        }
        return count;
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> adjList = new HashMap();
        Map<Integer, List<Integer>> undirectedAdjList = new HashMap();
        for (int connection[]: connections){
            adjList.putIfAbsent(connection[0], new ArrayList());
            adjList.get(connection[0]).add(connection[1]);
            
            undirectedAdjList.putIfAbsent(connection[0], new ArrayList());
            undirectedAdjList.get(connection[0]).add(connection[1]);
            undirectedAdjList.putIfAbsent(connection[1], new ArrayList());
            undirectedAdjList.get(connection[1]).add(connection[0]);
        }
        int routeToChange = 0;
        boolean[] visited = new boolean[n];
        // for (int i = 0; i < n; i++){
            routeToChange = dfs(0, adjList, visited, undirectedAdjList);
        // }
        return routeToChange;
    }
}