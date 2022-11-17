class Solution {
    public int lengthOfLastWord(String s) {
        boolean lastWordFlag = false;
        int len = 0;
        for (int i = s.length()-1; i>=0; i--){
            if (s.charAt(i) == ' '){
                if (lastWordFlag)
                    break;
                else
                    continue;
            }
            len++;
            lastWordFlag = true;
        }
        return len;
    }
}