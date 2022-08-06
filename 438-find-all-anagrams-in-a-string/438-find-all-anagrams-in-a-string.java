class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        List<Integer> sol = new ArrayList();
        if (len1 > len2) 
            return sol;

        int[] count = new int[26];
        char[] str1 = p.toCharArray();
        char[] str2 = s.toCharArray();
        
        for (int i = 0; i < len1; i++) {
            count[str1[i] - 'a']++;
            count[str2[i] - 'a']--;
        }
        if (allZero(count)) 
            sol.add(0);

        for (int i = len1; i < len2; i++) {
            count[str2[i]- 'a']--;
            count[str2[i-len1] - 'a']++;
            if (allZero(count))
                sol.add(i-len1+1);
        }

        return sol;
    }
    
    boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}