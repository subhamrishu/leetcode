// class Solution {
//     int dfs(int currNode, Map<Integer, List<Integer>> adjList, boolean[] visited, 
//            Map<Integer, List<Integer>> undirectedAdjList){
//         // if (visited[currNode] == 0)
//         //     return 0;
//         visited[currNode] = true;
//         // if (adjList.get(currNode) == null)
//         //     return 1;
//         int count = 0;
//         for (int node: undirectedAdjList.get(currNode)){
//             if (visited[node] == false){
//                 if(adjList.get(currNode) !=null)
//                     count += adjList.get(currNode).contains(node) == true ? 1 : 0 ;
//                 count += dfs(node, adjList, visited, undirectedAdjList);
//             }
//         }
//         return count;
//     }
//     public int minReorder(int n, int[][] connections) {
//         Map<Integer, List<Integer>> adjList = new HashMap();
//         Map<Integer, List<Integer>> undirectedAdjList = new HashMap();
//         for (int connection[]: connections){
//             adjList.putIfAbsent(connection[0], new ArrayList());
//             adjList.get(connection[0]).add(connection[1]);
            
//             undirectedAdjList.putIfAbsent(connection[0], new ArrayList());
//             undirectedAdjList.get(connection[0]).add(connection[1]);
//             undirectedAdjList.putIfAbsent(connection[1], new ArrayList());
//             undirectedAdjList.get(connection[1]).add(connection[0]);
//         }
//         int routeToChange = 0;
//         boolean[] visited = new boolean[n];
//         // for (int i = 0; i < n; i++){
//             routeToChange = dfs(0, adjList, visited, undirectedAdjList);
//         // }
//         return routeToChange;
//     }
// }
class Solution {
    int count = 0;
    void dfs(int currNode, List<List<Integer>> out, 
            List<List<Integer>> in, boolean[] visited){
        visited[currNode] = true;
        // int count = 0;
        for(int i = 0; i < out.get(currNode).size(); i++){
            if (visited[out.get(currNode).get(i)] == false){
                dfs(out.get(currNode).get(i), out, in, visited);
                count++;
            }
        }
        for(int i = 0; i < in.get(currNode).size(); i++){
            if (visited[in.get(currNode).get(i)] == false)
                dfs(in.get(currNode).get(i), out, in, visited);
        }
        // return count;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> out = new ArrayList();
        List<List<Integer>> in = new ArrayList();
        for (int i =0; i<n; i++){
            out.add(new ArrayList());
            in.add(new ArrayList());
        }
        for(int edges[]: connections){
            out.get(edges[0]).add(edges[1]);
            in.get(edges[1]).add(edges[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, out, in, visited);
        return count;
    }
}