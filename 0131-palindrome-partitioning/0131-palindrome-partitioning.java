class Solution {
    boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    void helper(String s, List<String> temp, List<List<String>> sol, int start){
        if (start == s.length()){
            sol.add(new ArrayList<>(temp));
        }
        for (int i = start; i < s.length(); i++){
            if (isPalindrome(s, start, i)){
                temp.add(s.substring(start, i+1));
                helper(s, temp, sol, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> sol = new ArrayList<>();
        helper(s, new ArrayList<>(), sol, 0);
        return sol;
    }
}