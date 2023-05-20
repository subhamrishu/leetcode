class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[512];
        Arrays.fill(index, -1);
        int max = 0;
        int k = 0, j = 0;
        for (int i = 0; i < s.length(); i++){
            if (index[s.charAt(i)] != -1){ //character not present in sliding window
                // k = index[s.charAt(i)]+1;
                k = Math.max(k, index[s.charAt(i)]+1);
            }
            index[s.charAt(i)] = i;
            j++;
            max = Math.max(max, j-k);
            // System.out.println(s.charAt(i) +" "+k+" "+j+" "+max);
        }
        return max;
    }
}