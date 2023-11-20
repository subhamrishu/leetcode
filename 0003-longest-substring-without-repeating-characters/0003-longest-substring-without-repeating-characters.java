class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[512];
        Arrays.fill(freq, 0);
        
        int j = 0, ans = 0;
        char str[] = s.toCharArray();
        
        for (int i = 0; i < str.length; i++){
            freq[str[i]]++;
            while (j <= i && freq[str[i]] > 1){
                freq[str[j++]]--;
            }
            ans = Math.max(ans, (i-j+1));
        }
        return ans;
    }
}