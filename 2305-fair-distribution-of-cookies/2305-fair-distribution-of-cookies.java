class Solution {
    int ans  = Integer.MAX_VALUE;
    void helper(int[] cookies, int curr, int k, int[] temp){
        if (curr == cookies.length){
            int max = 0;
            for (int i : temp){
                max = Math.max(max, i);
            }
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++){
            temp[i] += cookies[curr];
            helper(cookies, curr+1, k, temp);
            temp[i] -= cookies[curr];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return ans;
    }
}