class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Hash = new int[26];
        for (char c: s1.toCharArray()){
            s1Hash[c-'a']++;
        }
        int l1 = s1.length();
        char[] s2ch = s2.toCharArray();
        
        for (int i = 0; i <= s2ch.length-l1; i++){
            int j = i, count = 0;
            int[] copy=s1Hash.clone();
            while(j < s2.length() && copy[s2ch[j]-'a'] > 0){
                copy[s2ch[j]-'a']--;
                count++;
                j++;
            }
            if (count == l1)
                return true;
        }
        return false;
    }
}