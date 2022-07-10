class GraphNode{
    int node;
    double value;
    GraphNode(int source, double val){
        node = source;
        value = val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Set<String> set = new HashSet();
        Map<String, Integer> map = new HashMap();
        
        for (List<String> l : equations){
            set.add(l.get(0));
            set.add(l.get(1));
        }
        int k  = 0;
        for(String s: set){
            map.put(s, k++);
        }
        int m = set.size();
        double[][] matrix = new double[m][m];
        k = 0;
        for(List<String> l: equations){
            int a  = map.get(l.get(0));
            int b = map.get(l.get(1));
            matrix[a][b] = values[k++];
            matrix[b][a] = 1/matrix[a][b];
        }
       
        double[] sol = new double[queries.size()];
        Arrays.fill(sol, -1.0);
        k = 0;
        // System.out.println(map);
        for(List<String> l : queries){
            int source = map.getOrDefault(l.get(0), -1);
            int destination = map.getOrDefault(l.get(1), -1);
            // System.out.println(source+" "+ destination+" "+Arrays.toString(sol));
            if (source == -1 || destination == -1){
                sol[k++] = -1;
                continue;
            }
            if (source == destination){
                sol[k++] = 1;
                continue;
            }
            Queue<GraphNode> q = new LinkedList();
            boolean[] visited = new boolean[set.size()];
            q.offer(new GraphNode(source, 1.0));
            // int ans = 1;
            while(q.size()!=0){
                GraphNode out = q.poll();
                visited[out.node] = true;
                if (out.node == destination){
                        // ans* = matrix[source][out];
                        sol[k] = out.value;
                        break;
                }
                for(String s: set){
                    int neighbor = map.get(s);
                    if (!visited[neighbor] && matrix[out.node][neighbor]!=0.0){
                        q.add(new GraphNode(neighbor, out.value*matrix[out.node][neighbor]));
                    }
                }
            }
            k++;
        }
        return sol;
    }
}