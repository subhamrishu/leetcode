class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        ArrayList<Integer> visited = new ArrayList<>();

        int[] outdegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites){
            adjList[edge[1]].add(edge[0]);
            outdegree[edge[0]]++;
        }
        for(int i= 0; i < numCourses; i++){
            if (outdegree[i] == 0){
                visited.add(i);
            }
        }
        for (int i = 0; i < visited.size(); i++){
            for (int node: adjList[visited.get(i)]){
                if (--outdegree[node] == 0) 
                    visited.add(node);
            }
        }
        return visited.size() == numCourses;

    }
}