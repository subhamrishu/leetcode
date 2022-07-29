class Solution {
    void initializeDictionary(Map<Character, String> map){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");
    }
    void backTrack(String digits, Map<Character, String> map, List<String> sol, int index, StringBuilder curr){
        if (index == digits.length()){
            sol.add(curr.toString());
            return;
        }
        
        for(char c: map.get(digits.charAt(index)).toCharArray()){
            curr.append(c);
            backTrack(digits, map, sol, index+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap();
        // String[] map = new String[]{
        //   "", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"  
        // };
        
        initializeDictionary(map);
        /* iterative solution
        List<String> sol = new ArrayList();
        if (digits.length() == 0)
            return sol;
        
        sol.add("");
        for (char c: digits.toCharArray()){
            List<String> temp = new ArrayList();
            for (char d: map.get(c).toCharArray()){
                String s = ""+d;
                for (String word: sol){
                    temp.add(word+s);
                }
            }
            sol = temp;
        }
        return sol;
        */
        /* backtrack solution*/
        List<String> sol = new ArrayList();
        if (digits.length() == 0)
            return sol;
        backTrack(digits, map, sol, 0, new StringBuilder());
        return sol;
    }
}