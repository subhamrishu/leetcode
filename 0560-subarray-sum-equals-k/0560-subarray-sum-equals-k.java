class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        // System.out.println(Arrays.toString(prefixSum));
        int sol = 0;
        for (int i = 1; i <= n; i++){
            for (int j = i; j <= n; j++){
                // System.out.println("PrefixSum = "+(prefixSum[j] - prefixSum[i-1]));
                if ((prefixSum[j] - prefixSum[i-1]) == k)
                    sol++;
            }
        }
        return sol;
    }
}