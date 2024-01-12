class Solution {
    public int countVowelSubstrings(String word) {
        int i = 0, j = 0, sol = 0;
        
        // int[] freq = new int[26];
        char[] cs = word.toCharArray();
        int  n = word.length();
       while (i < n){
           while (i < n && "aeiou".indexOf(cs[i]) == -1){
               i++;
           }
           j = i;
           Set<Character> set = new HashSet<>();
           int[] freq = new int[26];
           while (j < n && "aeiou".indexOf(cs[j]) != -1){
               freq[cs[j]-'a']++;
               set.add(cs[j]);
               if (set.size() == 5)
                   sol++;
               
               j++;
           }
           
           i++;
           
       }
        return sol;
        
    }
}