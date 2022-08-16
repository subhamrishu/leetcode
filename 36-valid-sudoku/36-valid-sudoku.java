class Solution {
    boolean checkColumn(char[][] board, int col){
        int arr[] = new int[9];
        for (int i = 0; i < 9; i++){
            if (board[i][col] == '.')
                continue;
            int num = board[i][col] - '0' - 1;
            if (arr[num] == 1)
                return false;
            arr[num] = 1;
        }
        return true;
    }
    boolean checkRow(char[][] board, int row){
        int arr[] = new int[9];
        for (int i = 0; i < 9; i++){
            if (board[row][i] == '.')
                continue;
            int num = board[row][i] - '0' - 1;
            if (arr[num] == 1)
                return false;
            arr[num] = 1;
        }
        return true;
    }
    boolean checkLocalBoard(char[][] board, int r, int c){
        // System.out.println("Check Local Board called " + r +" "+c);
        int[][] dir = {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
        int[] arr = new int[9];
        for (int i = 0; i<9; i++){
            int x = r + dir[i][0];
            int y = c + dir[i][1];
            if (board[x][y] == '.')
                continue;
            int num = board[x][y] - '0' - 1;
            if (arr[num] == 1)
                return false;
            arr[num] = 1;
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if ((i == 1 || i == 4 || i == 7) && (j == 1 || j == 4 || j == 7) && !checkLocalBoard(board, i, j))
                    return false;
                if (board[i][j] != '.' && (!checkRow(board, i) || !checkColumn(board, j)))
                    return false;
            }
        }
        return true;
    }
}