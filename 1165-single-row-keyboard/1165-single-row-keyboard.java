class Solution {
    public int calculateTime(String keyboard, String word) {
        int last = 0;
        int[] idx = new int[26];
        for (int i = 0; i < keyboard.length(); i++){
            idx[keyboard.charAt(i)-'a'] = i;
        }
        int sum = 0;
        for (char ch: word.toCharArray()){
            sum += Math.abs(last - idx[ch-'a']);
            last = idx[ch-'a'];
        }
        return sum;
    }
}