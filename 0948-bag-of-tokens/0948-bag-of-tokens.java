class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int i = 0, j = n-1, score = 0, max = 0;
        while (i <= j){
            if (power >= tokens[i]){
                score++;
                max = Math.max(max, score);
                power -= tokens[i++];
            }else if (score > 0){
                score--;
                power += tokens[j--];
                max = Math.max(max, score);
            }else
                break;
        }
        return max;
    }
}