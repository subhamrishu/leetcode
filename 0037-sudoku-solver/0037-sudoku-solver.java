class Solution {
    boolean isValidPosition(char[][] board, int row, int col, char num){
        for (int i = 0; i < board.length; i++){
            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
            
            if (board[i][col] == num || board[row][i] == num || board[subgridRow][subgridCol] == num)
                return false;
        }
        return true;
    }
    boolean fillCells(char[][] board, int row, int col){
        if (row == board.length){
            return true;
        }
        else if (col == board[0].length){
            return fillCells(board, row+1, 0);
        }
        else if (board[row][col] != '.')
            return fillCells(board, row, col+1);
        
        for (char num = '1'; num <= '9'; num++){
            if (isValidPosition(board, row, col, num)){
                board[row][col] = num;
            
                if (fillCells(board, row, col+1))
                    return true;
            
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        fillCells(board, 0, 0);
    }
}