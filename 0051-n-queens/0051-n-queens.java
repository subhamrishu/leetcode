class Solution {
    boolean isColSafe(char[][] mat,  int r, int c){
        for (int i = 0; i < r; i++){
            if (mat[i][c] == 'Q')
                return false;
        }
        return true;
    }
    // boolean isRowSafe(char[][] mat, int r){
    //     for (int i = 0; i < mat[0].length; i++){
    //         if (mat[r][i] == 'Q')
    //             return false;
    //     }
    //     return true;
    // }
    boolean isDiagSafe(char[][] mat, int r, int c){
        int n = mat.length;
        int i = r, j = c;
        // while (r < n && c < n && r >=0. && c >= 0){
        //     if (mat[r][c] == 'Q')
        //         return false;
        //     r++; c++;
        // }
        // r = i;
        // c = j;
        // while (r < n && c < n && r >=0. && c >= 0){
        //     if (mat[r][c] == 'Q')
        //         return false;
        //     r++; c--;
        // }
        r = i;
        c = j;
        while (r < n && c < n && r >=0. && c >= 0){
            if (mat[r][c] == 'Q')
                return false;
            r--; c++;
        }
        r = i;
        c = j;
        while (r < n && c < n && r >=0. && c >= 0){
            if (mat[r][c] == 'Q')
                return false;
            r--; c--;
        }
        return true;
    }
    boolean isPosSafe(char[][] temp, int r, int c){
        if (isColSafe(temp, r, c) && isDiagSafe(temp, r, c)){
            return true;
        }
        return false;
    }
    void NQueensSol(List<List<String>> sol, char[][] temp, int r, int n){
        if (r == n){
            List<String> stringList= new ArrayList<>();
            for (char[] row : temp) {
                stringList.add(new String(row)); 
            }
            sol.add(stringList);
            return;
        }
        
        for (int i = 0; i < n; i++){
                // if (!isRowSafe(temp, i)) break;
            if (isPosSafe(temp, r, i)){
                // queen_flag = 1;
                temp[r][i] = 'Q';
                NQueensSol(sol, temp, r+1, n);
                temp[r][i] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> sol = new ArrayList<>();
        // List<String> temp = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();

        char[][] temp = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                temp[i][j] = '.';
            }
        }
        

        NQueensSol(sol, temp, 0, n);
        return sol;
    }
}