class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0, maxLength = 0, left = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++){
            freq[s.charAt(right)-'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right)-'A']);
            if ((right-left+1) - maxCount > k){ //window size invalid, shift window from the left side
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}