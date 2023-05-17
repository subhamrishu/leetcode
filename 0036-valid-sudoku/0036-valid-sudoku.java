class Solution {
    public static boolean checkBox(char[][] board, int i, int j){
        int[] box = new int[10];
        for (int k = i; k < i+3; k++){
            for (int l = j; l < j+3; l++){
                if (board[k][l]!='.'){
                    box[board[k][l] - '0']++;
                    if (box[board[k][l]-'0'] > 1)
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        
        for (int i = 0; i < 9; i++){
            int[] row = new int[10];
            int[] col = new int[10];
            for (int j = 0; j < 9; j++){
                if ((i%3 == 0) && (j%3 == 0)){
                    if (!checkBox(board, i, j))
                        return false;
                    
                }
                // System.out.println(board[i][j] + " "+board[j][i]);
                if (board[i][j] != '.'){
                    row[board[i][j] -'0']++;
                    if (row[board[i][j] -'0'] > 1) 
                        return false;
                    
                }
                if (board[j][i] != '.'){
                    col[board[j][i] - '0']++;
                    if (col[board[j][i] - '0'] > 1)
                        return false;
                }
                
            }
        }
        return true;
    }
}