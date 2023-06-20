class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        long div = 2*k+1;
        
        for (int i = 0; i < n; i++){
            prefixSum[i+1] += prefixSum[i] + nums[i];
        }
        int[] sol = new int[n];
        for (int i = 0; i < n; i++){
            if (i+k >= n || i-k < 0){
                sol[i] = -1;
            }
            else{
                sol[i] = (int)((prefixSum[i+k+1] - prefixSum[i-k])/div);
            }
        }
        return sol;
    }
}