class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int ans = 0;
        for (int t: time){
            t = t % 60;
            int complement = (t == 0)? 0: 60 - t;
            
            ans += map[complement];
            map[t] += 1;
        }
        return ans;
    }
}