class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, ans = 0, maxFreq = 0;
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        for (int right= 0; right < str.length; right++){
            maxFreq = Math.max(maxFreq, ++freq[str[right]-'A']);
            if (right - left + 1 - maxFreq > k){
                freq[str[left++]-'A']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}