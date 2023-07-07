class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] sc = answerKey.toCharArray();
        int n = answerKey.length(), tc = 0, fc = 0;
        int max = Integer.MIN_VALUE, left = 0;
        for (int right =0; right < n; right++){
            if (sc[right] == 'T')
                tc++;
            else 
                fc++;
            while (Math.min(tc, fc) > k){
                if (sc[left++] == 'T')
                    tc--;
                else
                    fc--;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}