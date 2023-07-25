class Solution {
//     class DSU{
//         int[] rank, parent;
//         DSU(int n){
//             rank = new int[n];
//             parent = new int[n];
//         }
//         int find(int x){
//             if (parent[x] == x)
//                 return x;
//             return parent[x] = find(x);
//         }
//         void union(int x, int y){
            
//         }
//     }
    boolean dfs(int[][] grid1, int[][] grid2,int i, int j){
        // if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] !=1){
        //     return true;
        // }
        if (grid1[i][j] != 1){
            // System.out.println(i+" "+j);
            return false;
        }
        grid2[i][j] = 2;
        boolean status = true;
        if (i+1 < grid2.length && grid2[i+1][j] ==1)
            status &= dfs(grid1, grid2, i+1, j);
        if (i-1 >= 0 && grid2[i-1][j] ==1)
            status &= dfs(grid1, grid2, i-1, j);
        if (j-1 >= 0 && grid2[i][j-1] ==1)
            status &= dfs(grid1, grid2, i, j-1);
        if (j+1 < grid2[0].length && grid2[i][j+1] ==1)
            status &= dfs(grid1, grid2, i, j+1);
        return status;
        
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++){
            for (int j = 0; j < grid2[0].length; j++){
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                    // System.out.println(i+" "+j);
                }
                
            }
        }
        return count;
    }
}