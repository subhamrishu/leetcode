class Solution {
    int checkForAllZero(int[] freq){
        for (int i = 0; i < 26; i++){
            if (freq[i] < 0)
                return 0;
        }
        return 1;
    }
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (String word: words){
            int[] freq  = new int[26];
            // System.out.print("Word = "+word);
            for (char ch: chars.toCharArray()){
                freq[ch-'a']++;
            }
            // System.out.println(Arrays.toString(freq));
            for (char ch: word.toCharArray()){
                freq[ch - 'a']--;
            }
            // System.out.println(Arrays.toString(freq));
            if (checkForAllZero(freq) == 1){
                sum += word.length();
            }
        }
        
        return sum;
        
    }
}