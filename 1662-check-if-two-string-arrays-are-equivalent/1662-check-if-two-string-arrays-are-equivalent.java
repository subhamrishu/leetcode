class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length; i++){
            sb.append(word1[i]);
        }
        int k = 0, i = 0, j = 0;
        for (i = 0; i < word2.length; i++){
            for (j = 0; j < word2[i].length() && k < sb.length(); j++){
                if (sb.charAt(k) != word2[i].charAt(j))
                    return false;
                k++;
            }
        }
        return k == sb.length() && i == word2.length && j == word2[i-1].length();
        // if (k != sb.length() - 1)
        //     return false;
        // return true;
    }
}