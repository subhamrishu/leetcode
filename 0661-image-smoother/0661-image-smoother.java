class Solution {
    int averageOfCells(int[][] img, int i, int j){
        int m = img.length;
        int n = img[0].length;
        
        int sum = img[i][j], count = 1;
        if (i-1 >= 0 && j-1 >= 0){
            sum += img[i-1][j-1];
            count++;
        }
        if (i - 1 >= 0){
            sum += img[i-1][j];
            count++;
        }
        if (i-1 >= 0 && j + 1 < n){
            sum += img[i-1][j+1];
            count++;
        }
        if (j-1 >= 0){
            sum += img[i][j-1];
            count++;
        }
        if (j+1 < n){
            sum += img[i][j+1];
            count++;
        }
        if (i+1 < m && j-1 >= 0){
            sum += img[i+1][j-1];
            count++;
        }
        if (i+1 < m){
            sum += img[i+1][j];
            count++;
        }
        if (i+1 < m && j+1 < n){
            sum += img[i+1][j+1];
            count++;
        }
        return (int)Math.floor((sum*1.0/count));
    }
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] sol = new int[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                sol[i][j] = averageOfCells(img, i, j);
            }
        }
        return sol;
    }
}