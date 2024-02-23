// class Solution {
//     int minCost = Integer.MAX_VALUE;
//     void dfs(Map<Integer, List<int[]>> adj, int[][] flights, int src, int dest, int k, int cost, boolean[] visited){
//         if (src == dest && k >= 0){
//             minCost = Math.min(minCost, cost);
//             return;
//         }else if (k == 0 || !adj.containsKey(src) || visited[src])
//             return;
//         visited[src] = true;
//         for (int[] node: adj.get(src)){
//             if (!visited[node[0]])
//                 dfs(adj, flights, node[0], dest, k-1, cost+node[1], visited);
//             // visited[node[0]] = false;
//         }
        
//     }
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         Map<Integer, List<int[]>> adj = new HashMap<>();
//         boolean[] visited = new boolean[n];
//         for (int[] node: flights){
//             if (!adj.containsKey(node[0])){
//                 adj.put(node[0], new ArrayList<>());
//             }
//             adj.get(node[0]).add(new int[]{node[1], node[2]});
//         }
//         dfs(adj, flights, src, dst, k+1, 0, visited);
//         return minCost == Integer.MAX_VALUE ? -1 : minCost;
//     }
// }

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] i : flights)
            adj.computeIfAbsent(i[0], value -> new ArrayList<>()).add(new int[] { i[1], i[2] });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { src, 0 });
        int stops = 0;

        while (stops <= k && !q.isEmpty()) {
            int sz = q.size();
            // Iterate on current level.
            while (sz-- > 0) {
                int[] temp = q.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node))
                    continue;
                // Loop over neighbors of popped node.
                for (int[] e : adj.get(node)) {
                    int neighbour = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbour])
                        continue;
                    dist[neighbour] = price + distance;
                    q.offer(new int[] { neighbour, dist[neighbour] });
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}