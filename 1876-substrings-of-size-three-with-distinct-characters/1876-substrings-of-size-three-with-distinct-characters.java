class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3)
            return 0;
        int ans = 0, sum = 1;
        int freq[] = new int[26];
        
        // HashMap<Character, Integer> map = new HashMap();
        char ch[] = s.toCharArray();
        freq[ch[0]-'a']++;
        // map.put(ch[0],1);
        
        for (int i = 1; i<s.length(); i++){
            if (i >=3){
                //sum -= map.get(ch[i-3]) == 1? 1: 0;
                //map.put(ch[i-3], map.get(ch[i-3])-1);
                
                sum -= freq[ch[i-3]-'a'] == 1 ? 1 : 0;
                freq[ch[i-3] - 'a']--;
            }
            freq[ch[i] - 'a']++;
            sum += freq[ch[i] - 'a'] == 1 ? 1 : 0;
            // map.putIfAbsent(ch[i], 0);
            // map.put(ch[i], map.get(ch[i])+1);
            // sum+= map.get(ch[i]) == 1 ? 1 : 0;
            
            if (sum == 3)
               ans++; 
            // System.out.println(i +" "+map+" "+sum);
        }
        return ans;
    }
}