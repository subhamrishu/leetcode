class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002];
        for (int num: nums){
            sum[num] += num;
        }
        for (int i = 2; i <= 10001; i++){
            sum[i] = Math.max(sum[i-1], sum[i]+sum[i-2]);
        }
        return sum[10001];
    }
}