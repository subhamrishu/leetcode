class Solution {
    class DSU{
        int[] parent, rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }
    
        int find(int x){
            if (x == parent[x])
                return x;
            return parent[x] = find(parent[x]); //path compression
        }
        boolean union(int x, int y){
            int xr = find(x), yr = find(y);
            if (xr == yr)
                return false;
            else if (rank[xr] > rank[yr]){
                parent[yr] = xr;
                rank[xr] += rank[yr];
            }
            else{
                parent[xr] = yr;
                rank[yr] += rank[xr];
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU uf = new DSU(n);
        for (int[] edge: edges){
            if (!uf.union(edge[0]-1, edge[1]-1))
                return edge;
        }
        return new int[0];
    }
}