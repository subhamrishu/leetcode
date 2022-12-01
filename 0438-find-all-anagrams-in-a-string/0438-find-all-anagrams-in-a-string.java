class Solution {
    boolean checkIfAllZero(int[] freq){
        for(int f : freq){
            if (f != 0)
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int s_len = s.length(), p_len = p.length();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        List<Integer> sol = new ArrayList<>();
        if (p_len > s_len)
            return sol;
        int[] freq = new int[26];
        for (int i = 0; i < p_len; i++){
            freq[pp[i]-'a']++;
            freq[ss[i]-'a']--;
        }
        if (checkIfAllZero(freq))
            sol.add(0);
        for (int i = p_len; i < s_len; i++){
            freq[ss[i]-'a']--;
            freq[ss[i-p_len]-'a']++;
            if (checkIfAllZero(freq))
                sol.add(i-p_len+1);
        }
        return sol;
    }
}