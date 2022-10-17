class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] counter =  new int[26];
        for (char ch : sentence.toCharArray()){
            counter[ch-'a']++;
        }
        for (int c: counter){
            if (c == 0)
                return false;
        }
        return true;
    }
}