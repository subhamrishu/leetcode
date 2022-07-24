class Solution {
    int binarySearch(int[][] matrix, int target, int row){
        int low = 0, high = matrix[0].length;
        while (low <= high){
            int mid = low + (high - low)/2;
            // System.out.println("******"+low+" "+mid+" "+high+"*****");
            if (matrix[row][mid] == target)
                return mid;
            else if(matrix[row][mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length, index=0;
        for (int i = 0; i < r; i++){
            if (matrix[i][c-1] >= target && matrix[i][0] <= target){
                index = binarySearch(matrix, target, i);
                // System.out.println(i+" "+index);
                if (index != -1)
                    return true;
            }
        }
        return false;
    }
}