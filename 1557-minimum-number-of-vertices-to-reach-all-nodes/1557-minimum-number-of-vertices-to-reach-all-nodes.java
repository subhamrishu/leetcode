class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // int[][] matrix = new int[n][n];
        int[] seen = new int[n];
        for(List<Integer> l :edges){
            seen[l.get(1)]=1;
        }
       
        List<Integer> sol = new ArrayList();
        for(int i = 0; i<n; i++){
            if (seen[i]==0)
                sol.add(i);
        }
        return sol;
    }
}