class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> sol = new ArrayList<>();
        
        char[] cs = currentState.toCharArray();
        int n  = cs.length;
        for (int i = 0; i < n-1; i++){
            if (cs[i] == '+' && cs[i+1] == '+'){
                String temp = currentState.substring(0,i) + "--" + (i+2 < n ? currentState.substring(i+2, n) : "");
                sol.add(temp);
            }
        }
        return sol;
    }
}