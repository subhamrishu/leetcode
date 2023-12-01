class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++){
            sb1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++){
            sb2.append(word2[i]);
        }
        if (sb1.toString().equals(sb2.toString()))
            return true;
        return false;
        
        // int k = 0, i = 0, j = 0;
        // for (i = 0; i < word2.length; i++){
        //     for (j = 0; j < word2[i].length() && k < sb.length(); j++){
        //         if (sb.charAt(k) != word2[i].charAt(j))
        //             return false;
        //         k++;
        //     }
        // }
        // return k == sb.length() && i == word2.length && j == word2[i-1].length();
        // if (k != sb.length() - 1)
        //     return false;
        // return true;
    }
}