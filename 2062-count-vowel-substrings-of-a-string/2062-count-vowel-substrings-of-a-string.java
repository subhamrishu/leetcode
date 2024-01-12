class Solution {
    boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int countVowelSubstrings(String word) {
        int i =0, j =0, left = 0, distinct = 0, sol = 0;
        char[] cs = word.toCharArray();
        int[] freq = new int[26];
        int n = word.length();
        for (int right = 0; right < n; right++){
            if (isVowel(cs[right])){
                if (++freq[cs[right] - 'a'] == 1){
                    distinct++;
                }
                while (distinct == 5){
                   if (--freq[cs[i++] - 'a'] == 0){
                       distinct--;
                   }
                    
                }
                sol += i - left;
            }else{
                i = left = right + 1;
                distinct = 0;
                freq = new int[26];
            }
        }
        return sol;
    }
}