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
    public int makeConnected(int n, int[][] connections) {
        DSU uf = new DSU(n);
        int count = 0;
        for (int[] edge: connections){
            if (!uf.union(edge[0], edge[1])){
                count++;//redundant connections
            }
        }
        int not_connected = -1;
        for (int i = 0; i < n; i++){
            if (i == uf.parent[i])
                not_connected++;
        }
        // System.out.println(count+" "+not_connected);
        return not_connected <= count ? not_connected : -1;
    }
}