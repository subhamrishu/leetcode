class Solution {
    public int partitionString(String s) {
        int sol = 0;
        int[] freq = new int[26];
        for (char ch: s.toCharArray()){
            if (freq[ch-'a'] == 1){
                sol++;
                freq = new int[26];
            }
            freq[ch-'a'] = 1;
        }
        return sol+1;
    }
}