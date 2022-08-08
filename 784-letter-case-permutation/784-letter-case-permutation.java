class Solution {
    List<String> sol;
    void permutation(int index, char[] ch){
        if (index == ch.length){
            sol.add(new String(ch));
            return;
        }
        
        if (ch[index] >= '0' && ch[index] <= '9'){
            permutation(index+1, ch);
            return;
        }
       
        ch[index] = Character.toUpperCase(ch[index]);
        permutation(index+1, ch);

        ch[index] = Character.toLowerCase(ch[index]);
        permutation(index+1, ch);
        
    }
    
    public List<String> letterCasePermutation(String s) {
        sol = new ArrayList();
        permutation(0, s.toCharArray());
        return sol;
    }
}