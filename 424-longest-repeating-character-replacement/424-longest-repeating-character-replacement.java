class Solution {
    int findMax(int[] arr){
        int max = -1;
        for (int i = 0; i<26; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        /* Intuitive SOlution: O(26*n)
        int[] freq = new int[26];
        int left = 0, right = 0;
        int max = -1;
        while ((left <= right) && (right < s.length())){
            freq[s.charAt(right) - 'A']++;
           
            while (((right - left + 1) - findMax(freq)) > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            
            max = Math.max(max, (right- left + 1));
            right++;
        }
        return max;
        */
        /* Not so Intuitive solution : O(n)*/
        int freq[] = new int[26];
        int left = 0, right = 0;
        int max = 0, maxFreq = 0;
        while (right < s.length()){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(right)-'A']);
            
            while((right-left+1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, (right-left+1));
            right++;
        }
        return max;
    }
}