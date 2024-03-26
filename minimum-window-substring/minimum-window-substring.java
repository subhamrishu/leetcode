class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[123];
        Arrays.fill(freq, 0); // Initialize frequencies to 0
        
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        if (cs.length < ct.length) return "";
        
        int remaining = ct.length;
        for (int i = 0; i < ct.length; i++){
            freq[ct[i]]++; // Increment frequency for each character in t
        }
        
        int left = 0, start = -1, min = cs.length + 1;

        for(int right = 0; right < cs.length; right++){
            if (freq[cs[right]] > 0){
                remaining--;
            }
            freq[cs[right]]--; // Decrement frequency for each character in s

            while (remaining == 0){
                if ((right - left + 1) < min){
                    min = right - left + 1;
                    start = left;
                }
                freq[cs[left]]++; // Restore frequency for characters as window moves
                if (freq[cs[left]] > 0)
                    remaining++;
                left++;
            }
        }
        return min == cs.length + 1 ? "" : s.substring(start, start + min);
    }
}
