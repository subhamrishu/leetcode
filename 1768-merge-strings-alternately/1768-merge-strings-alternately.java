class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int l1 = word1.length(), l2 = word2.length();
        int i = 0, j = 0;
        while ( i < l1 || j < l2){
            if (i < l1)
                sb.append(word1.charAt(i++));
            if (j < l2)
                sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}