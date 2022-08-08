class Solution {
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color)
                return image;
            int oldColor = image[sr][sc];
            image[sr][sc] = color;
            for (int i = 0; i<4; i++){
                int newX = sr + x[i], newY = sc + y[i];
                if (newX>=0 && newX < image.length && newY >= 0 && newY < image[0].length  && image[newX][newY] == oldColor){
                    floodFill(image, newX, newY, color);
                }
            }
        return image;
    }
}