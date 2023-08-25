class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e');set.add('i');set.add('o');set.add('u');
        int max_vol = 0;
        
        for (int i = 0; i < k; i++){
            if (set.contains(s.charAt(i))){
                max_vol += 1;
            }
        }
        int j  = k;
        int prev = max_vol;
        for (int i = k; i < s.length(); i++){
            
            int curr_max = prev;
            if (set.contains(s.charAt(i-k))){
                curr_max-=1;
            }
            if (set.contains(s.charAt(i))){
                curr_max +=1;
            }
            max_vol = max_vol < curr_max ? curr_max : max_vol;
            prev = curr_max;
            // System.out.println(s.charAt(i) + " "+s.charAt(j) + " "+curr_max+" " +max_vol);
            // j++;
            
        }
        return max_vol;
    }
}