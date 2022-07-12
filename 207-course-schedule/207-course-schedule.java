class Solution {
    int dfs(List<List<Integer>> adjList, int currCourse, boolean[] visited, boolean[] explored){
        if (explored[currCourse])
            return 0;
        if (visited[currCourse])
            return 1;
        if (adjList.get(currCourse).size() == 0){
            visited[currCourse] = true;
            return 1;
        }
        explored[currCourse] = true;
        int t = 0;
        for (int i = 0; i < adjList.get(currCourse).size();i++){
            t = dfs(adjList, adjList.get(currCourse).get(i), visited, explored);
            
            if (t == 1){
                // System.out.println("Removing:" + adjList.get(currCourse).get(i));
                adjList.get(currCourse).remove(i);
                i -=1;
            }
        }
        explored[currCourse] = false;
        visited[currCourse] = true;
        return t;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList();
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int completed = 0;
        // Set<Integer> visited = new HashSet();
        boolean[] visited = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            dfs(adjList, i, visited, explored);
        }
        // System.out.println(Arrays.toString(explored));
        for(int i= 0; i < numCourses; i++){
            // System.out.println("i= "+i +" "+adjList.get(i));
            completed += adjList.get(i).size() == 0 ? 1 : 0;
        }
        // System.out.println(completed);
        return completed == numCourses;
    }
}