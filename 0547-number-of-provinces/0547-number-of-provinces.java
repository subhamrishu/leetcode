class Solution {
    private void dfs(int i, boolean[] visited, int[][] isConnected){
        visited[i] = true;
        for (int k = 0; k < isConnected.length; k++){
            if (isConnected[i][k]==1 && !visited[k])
                dfs(k, visited, isConnected);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // List<Integer>[] graph = new List[n];
        // for (int i = 0; i< n; i++){
        //     graph[i] = new ArrayList<>();
        // }
        // for (int i = 0; i<n ;i++){
        //     for (int j = i+1; j < n; j++){
        //         if (isConnected[i][j] == 1){
        //             graph[i].add(j);
        //             graph[j].add(i);
        //         }
        //     }
        // }
        int provinces = 0;
        boolean[] visited = new boolean[n];
        // Arrays.fill(visited, false);
        for(int i = 0; i < n; i++){
            // System.out.println(graph[i]);
            if (!visited[i]){
                provinces++;
                dfs(i, visited, isConnected);
            }
            // System.out.println(i+" "+provinces+ " "+Arrays.toString(visited));
        }
        return provinces;
    }
}