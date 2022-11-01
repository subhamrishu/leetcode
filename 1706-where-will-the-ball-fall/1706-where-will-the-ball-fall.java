class Solution {
    // int[][] dp;
    int r, c;
    int findPath(int[][] grid, int i, int j){
        
        while (i!=r && j!=c){
            
            if(grid[i][j] == 1 && j+1 < c && grid[i][j+1] == 1){
                i = i+1;
                j = j+1;
            }
            else if(grid[i][j] == -1 && j-1 >= 0 && grid[i][j-1] == -1){
                i = i+1;
                j = j-1;
            }
            else if((grid[i][j] ==1 && j+1 < c && grid[i][j+1] == -1) || 
                    (grid[i][j] == -1 && j-1 >=0 && grid[i][j-1] ==1) ||
                   (j+1 >= c || j -1 < 0))
                return -1;
            // else if ( ) 
            //     return -1;
            // if()
        }
        if(i == r)
            return j;
        return -1;
    }
    public int[] findBall(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int[] sol = new int[c];
        // dp = new int[r][c];
        for (int i = 0; i < c; i++){
            // System.out.print(findPath(grid, 0, i)+" ");
            sol[i] = findPath(grid, 0, i);
        }
        // System.out.println();
        return sol;
    }
}