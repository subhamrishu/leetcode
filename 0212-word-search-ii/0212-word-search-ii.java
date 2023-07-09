class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean endFlag;
        TrieNode(){
            children = new TrieNode[26];
            endFlag = false;
        }
    }
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()){
            int idx = ch - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.endFlag = true;
    }
    int[] dir = {0, -1, 0, 1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word: words){
            insert(word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited;
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int idx = board[i][j] - 'a';
                visited = new boolean[m][n];
                dfs(i, j, visited, sol, root, new StringBuilder(), board);
            }
        }
        // List<String> ans = new ArrayList<>();
        // for (String word: sol){
        //     ans.add(word);
        // }
        return sol;
    }
    void dfs(int i, int j, boolean[][] visited, List<String> sol, TrieNode currNode, StringBuilder currStr, char[][] board){
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || visited[i][j]){
            // if (i < board.length && i >= 0 && j >= 0 && j < board[0].length )
            //     System.out.println(visited[i][j]);
            return;
        }
        int idx = board[i][j] - 'a';
        if (currNode.children[idx] == null){
            return;
        }
        visited[i][j] = true;
        
        // System.out.println(currStr + " "+ board[i][j]);
        
        
        currNode = currNode.children[idx];
        currStr.append(board[i][j]);
        if (currNode.endFlag){
            sol.add(currStr.toString());
            currNode.endFlag = false;
        }
        
        for (int k = 0; k < 4; k++){
            int i1 = i + dir[k], j1 = j + dir[k+1];
            // System.out.println(currStr + " "+i1 +" "+j1);
            dfs(i1, j1, visited, sol, currNode, currStr, board);
        }
        // System.out.println(currStr);
        visited[i][j] = false;
        currStr.deleteCharAt(currStr.length()-1);
    }
}