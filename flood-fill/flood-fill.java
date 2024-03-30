class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    void dfs(int[][] image, int sr, int sc, int color, int lastColor, boolean[][] visited){
        visited[sr][sc] = true;
        image[sr][sc] = color;
        for (int i = 0; i < 4; i++){
            int x = sr + dir[i];
            int y = sc + dir[i+1];
            
            if (x >= 0 && x < image.length && y >=0 && y < image[0].length && !visited[x][y] && image[x][y] == lastColor){
                dfs(image, x, y, color, image[x][y], visited);
            }
        }
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        dfs(image, sr, sc, color, image[sr][sc], new boolean[m][n]);
        return image;
    }
}