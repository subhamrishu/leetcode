class Solution {
    public int partitionString(String s) {
        int sol = 0, n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++){
            int j = i;
            freq = new int[26];
            while (j < n && freq[s.charAt(j)-'a'] == 0){
                freq[s.charAt(j)-'a']++;
                j++;
            }
            i = j - 1;
            sol++;
        }
        return sol;
    }
}