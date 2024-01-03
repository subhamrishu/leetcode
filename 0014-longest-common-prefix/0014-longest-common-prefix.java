class Solution {
    //horizontal scanning
//     public String longestCommonPrefix(String[] strs) {
//         int end = strs[0].length();
        
//         for (int i = 1; i < strs.length; i++){
//             char[] ch = strs[i].toCharArray();
//             int j;
//             for (j = 0; j < ch.length && j < end; j++){
//                 if (ch[j] != strs[0].charAt(j)){
//                     break;
//                 }
//             }
//             end = j;
//             if (end == 0)
//                 break;
//         }
//         return strs[0].substring(0, end);
    // }
    //vertical scanning
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}