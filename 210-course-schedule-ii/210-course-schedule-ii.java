class Solution {
    List<List<Integer>> buildGraph(int n, int[][] edges, int[] degree){
         List<List<Integer>> adjList = new ArrayList();
         for (int i = 0; i < n; i++){
             adjList.add(new ArrayList());
         }
         for(int i = 0; i < edges.length; i++){
             adjList.get(edges[i][1]).add(edges[i][0]);
             degree[edges[i][0]]+=1;
         }
         return adjList;
     }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int outDegree[] = new int[numCourses];
        List<Integer> orderOfCourseTaken = new ArrayList();
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites, outDegree);
        
        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++){
            if (outDegree[i] == 0){
                q.offer(i);
            }
        }
        int k = 0;
        while (q.size()!=0){
            int canTake = q.poll();
            orderOfCourseTaken.add(canTake);
            for (int i = 0; i < graph.get(canTake).size(); i++){
                int dependent = graph.get(canTake).get(i);
                outDegree[dependent]--;
                if(outDegree[dependent] == 0)
                    q.offer(dependent);
            }
        }
        
        if(orderOfCourseTaken.size() != numCourses)
            return new int[]{};
        
        int[] res = new int[orderOfCourseTaken.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = orderOfCourseTaken.get(i);
        }
        return res;
    }
}