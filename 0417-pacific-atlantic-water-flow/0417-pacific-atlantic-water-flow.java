class Solution {
//     int[] dir = {-1, 0, 1, 0, -1};
//     int dfs(int[][] heights, int[][] ocean, boolean[][] visited, int i, int j){
//         // if (i < 0 || i >= heights.length || j < 0 || j > heights[0].length)
//         //     return -1;
//         if (visited[i][j]) return ocean[i][j];
        
//         visited[i][j] = true;
//         int[] temp = new int[4];
//         for (int k = 0; k < 4; k++){
//             int i1 = i + dir[k], j1 = j + dir[k+1];
//             if (i1 >= 0 && i1 < heights.length && j1 >= 0 && j1 < heights[0].length && heights[i][j] >= heights[i1][j1])
//                 temp[k] = dfs(heights, ocean, visited, i1, j1);
//                 // ocean[i][j] = Math.max(ocean[i][j], dfs(heights, ocean, visited, i1, j1));
//         }
//         if ((temp[0] == 1 || temp[1] == 1 || temp[2] == 1 || temp[3] == 1 || ocean[i][j] == 1) && ((temp[0] == 2 || temp[1] == 2 || temp[2] == 2 || temp[3] == 2 || ocean[i][j] == 2)))
//             ocean[i][j] = 3;
//         else{
//             for (int k = 0; k < 4; k++){
//                 ocean[i][j] = Math.max(temp[k], ocean[i][j]);
//             }
//         }
//         return ocean[i][j];
        
        
//     }
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         int m = heights.length, n = heights[0].length;
//         int[][] ocean = new int[m][n];
//         //1-> pacific, 2-> Atlantic, 3-> Both
//         //top row
//         for (int i = 0; i<n; i++){
//             ocean[0][i] = 1;
//         }
//         //left column
//         for (int i = 0; i < m; i++){
//             ocean[i][0] = 1;
//         }
//         //bottom row
//         for (int i = 0; i < n; i++){
//             ocean[m-1][i] = 2;
//         }
//         //right column
//         for (int i = 0; i < m; i++){
//             ocean[i][n-1] = 2;
//         }
//         //top right
//         ocean[0][n-1] = 3;
//         //bottom left
//         ocean[m-1][0] = 3;
        
//         boolean[][] visited = new boolean[m][n];
//         List<List<Integer>> sol = new ArrayList<>();
//         for (int i = 0; i < m; i++){
//             for (int j = 0; j < n; j++){
//                 int o = dfs(heights, ocean, visited, i, j);
//                 if (o == 3)
//                     sol.add(new ArrayList<>(Arrays.asList(i, j)));
//             }
//         }
//         System.out.println(Arrays.deepToString(ocean));
//         return sol;
//     }
    void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight){
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || visited[i][j] || prevHeight > heights[i][j])
            return;
        visited[i][j] = true;
        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
    }
     public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < m; i++){
            dfs(heights, pacific, i, 0, heights[i][0]);
            dfs(heights, atlantic, i, n-1, heights[i][n-1]);
        }
        for (int i = 0; i < n; i++){
            dfs(heights, pacific, 0, i, heights[0][i]);
            dfs(heights, atlantic, m-1, i, heights[m-1][i]);
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if (atlantic[i][j] && pacific[i][j])
                    sol.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        return sol;
     }
}