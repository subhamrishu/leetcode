class Solution {
    boolean isPalindrome(List<Character> s){
        // char[] cs = s.toCharArray();
        int i = 0, j = s.size()-1;
        while (i < j){
            if (s.get(i) != s.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    int dfs(char[] cs, List<Character> s1, List<Character> s2, int curr){
        if (curr == cs.length){
            if (isPalindrome(s1) && isPalindrome(s2)){
                return s1.size() * s2.size();
            }
            else 
                return 0;
        }
        s1.add(cs[curr]);
        int a = dfs(cs, s1, s2, curr+1);
        s1.remove(s1.size()-1);

        s2.add(cs[curr]);
        int b = dfs(cs, s1, s2, curr+1);
        s2.remove(s2.size()-1);

        int c = dfs(cs, s1, s2, curr+1);
        return Math.max(a, Math.max(b,c));
        
    }
    public int maxProduct(String s) {
        char[] cs = s.toCharArray();
        return dfs(cs, new ArrayList<>(), new ArrayList<>(), 0);
    }
}