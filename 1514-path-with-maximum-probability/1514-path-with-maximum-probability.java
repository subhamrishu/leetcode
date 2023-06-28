// class Solution {
//     class Node{
//         int node;
//         double cost;
//         public Node(int node, double cost){
//             this.node = node;
//             this.cost = cost;
//         }
//     }
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//         Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        
//         for (int i = 0; i < edges.length; i++){
//             if (!graph.containsKey(edges[i][0])) graph.put(edges[i][0], new HashMap<>());
//             graph.get(edges[i][0]).put(edges[i][1], Math.log(succProb[i]));
//         }
//         PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> {
//             return b.cost - a.cost;
//         });
        
//         Set<Integer> visited = new HashSet<>();
        
//         pq.offer(new Node(start, 0));
//         double max = 0;
        
//         while (!pq.isEmpty()){
//             Node curr = pq.poll();
//             if (visited.contains(curr.node))
//                 continue;
//             max = Math.max(max, curr.cost);
//             if (curr.node == end)
//                 continue;
//             visited.add(curr.node);
            
            
//             if (!graph.containsKey(curr.node)) continue;
            
//             for (int neighbor: graph.get(curr.node).keySet()){
//                 pq.offer(new Node(neighbor, curr.cost + graph.get(curr.node).get(neighbor)));
//             }
            
//         }
//         return max;
//     }
// }
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        pq.add(new Pair<>(1.0, start));
        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();
            if (curNode == end) {
                return curProb;
            }
            for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.getKey();
                double pathProb = nxt.getValue();
                if (curProb * pathProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = curProb * pathProb;
                    pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
                }
            }
        }

        return 0d;
    }
}