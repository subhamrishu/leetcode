class Solution {
    int findIndex(int[][] matrix, int target){
        int low = 0, high = matrix.length;
        int n = matrix[0].length-1;
        while(low < high){
            int mid = low + (high-low)/2;
            if (matrix[mid][n] == target)
                return mid;
            else if (matrix[mid][n] < target)
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    boolean findElement(int[] arr, int target){
        int low = 0, high = arr.length;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int index = findIndex(matrix, target);
        if (index == matrix.length)
            return false;
        return findElement(matrix[index], target);
    }
}