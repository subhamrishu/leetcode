class Solution {
    void helper(List<String> sol, Map<Character, String> map, String digits, StringBuilder sb, int curr){
        if (sb.length() == digits.length()){
            sol.add(sb.toString());
            return;
        }
        for (char ch: map.get(digits.charAt(curr)).toCharArray()){
            sb.append(ch);
            helper(sol, map, digits, sb, curr+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> sol = new ArrayList<>();
        if (digits.length() == 0)
            return sol;
        Map<Character, String> map = new HashMap<>(){{
           put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        helper(sol, map, digits, new StringBuilder(), 0);
        return sol;
    }
}