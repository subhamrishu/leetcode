class Solution {
    public String longestCommonPrefix(String[] strs) {
        int end = strs[0].length();
        
        for (int i = 1; i < strs.length; i++){
            char[] ch = strs[i].toCharArray();
            int j;
            for (j = 0; j < ch.length && j < end; j++){
                if (ch[j] != strs[0].charAt(j)){
                    break;
                }
            }
            end = j;
            if (end == 0)
                break;
        }
        return strs[0].substring(0, end);
    }
}