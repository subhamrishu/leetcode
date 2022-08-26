class Solution {
    int findMax(int[] arr){
        int max = -1;
        for (int i = 0; i<26; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
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
    }
}