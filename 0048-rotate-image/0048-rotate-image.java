class Solution {
    void transpose(int[][] matrix){
        for (int i = 0; i<matrix.length; i++){
            for (int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    void reflect(int[][] matrix){
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][c - 1 - j];
                matrix[i][c - 1 - j] = temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
}