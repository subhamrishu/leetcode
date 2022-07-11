class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // int[][] matrix = new int[n][n];
        int[] degree = new int[n];
        for(List<Integer> l :edges){
            // int a = l.get(0);
            int b = l.get(1);
            degree[b]+=1;
        }
       
        List<Integer> sol = new ArrayList();
        for(int i = 0; i<n; i++){
            if (degree[i]==0)
                sol.add(i);
        }
        return sol;
    }
}