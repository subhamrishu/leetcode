class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol = new ArrayList<>();
        if (matrix.length == 0)
            return sol;
        int rowBegin = 0, colBegin = 0, rowEnd = matrix.length-1, colEnd = matrix[0].length-1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
                for (int i = colBegin; i <= colEnd; i++){
                    sol.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for(int i = rowBegin; i <= rowEnd; i++){
                    sol.add(matrix[i][colEnd]);
                }
                colEnd--;
                if (rowBegin <= rowEnd){
                        for(int i = colEnd; i >= colBegin; i--){
                            sol.add(matrix[rowEnd][i]);
                        }
                }
                rowEnd--;
                if (colBegin <= colEnd){
                        for(int i=rowEnd; i >= rowBegin; i--){
                            sol.add(matrix[i][colBegin]);
                        }
                }
                colBegin++;
        }
        return sol;
    }
}