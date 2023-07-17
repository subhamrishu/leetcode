class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    boolean helper(char[][] board, String word, StringBuilder sb, int i, int j, boolean[][] visited){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j])
            return false;
        if (word.charAt(sb.length()) != board[i][j])
            return false;

        visited[i][j] = true;
        sb.append(board[i][j]);
        if (sb.length() == word.length()){
            if (sb.toString().equals(word))
                return true;
            else 
                return false;
        }
        
        for (int k = 0; k < 4; k++){
            int i1 = i + dir[k], j1 = j + dir[k+1];
            if (helper(board, word, sb, i1, j1, visited)) return true;
        }
        sb.deleteCharAt(sb.length()-1);
        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m == 1 && n == 1 && word.length() == 1)
            return board[0][0] == word.charAt(0);
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (helper(board, word, new StringBuilder(), i, j, new boolean[m][n])) return true;
            }
        }
        return false;
    }
}