class Solution {
    static void helper(List<String> sol, int open, int close, int n, StringBuilder str){
        if(str.length() == 2*n){
            sol.add(str.toString());
            return;
        }
        if (open < n){
            str.append('(');
            helper(sol, open+1, close, n, str);
            str.deleteCharAt(str.length()-1);
        }
        if (open > close){
            str.append(')');
            helper(sol, open, close+1, n, str);
            str.deleteCharAt(str.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<>();
        helper(sol, 0, 0, n, new StringBuilder());
        return sol;
    }
}