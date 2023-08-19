class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n-1;
        while (r < m && c >= 0){
            if (matrix[r][c] == target)
                return true;
            if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }
}