class Solution {
    /* DP Solution - TLE
    int dp[];
    int helper(int[] nums, int k, int ind){
        if(ind >= nums.length-1)
            return nums[nums.length-1];
        int val = 0, max = Integer.MIN_VALUE;
        if (dp[ind]!=Integer.MIN_VALUE)
            return dp[ind];
        for (int i = 1; i <= k; i++){
            
            if ((ind + i) < nums.length && nums[ind+i] < 0){
                val = helper(nums, k, ind+i);
                max = Math.max(max, nums[ind] + val);
            }
            else if((ind + i) < nums.length)
                max = max + nums[ind];
        }
        dp[ind] = max;
        return max;
    }
    public int maxResult(int[] nums, int k) {
        // System.out.println(Integer.MIN_VALUE);
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return helper(nums, k, 0);
    }
    */
     public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>(); // store index of `nums` elements, elements is in decreasing order, the front is the maximum element.
        dq.offer(0);
        for (int i = 1; i < n; ++i) {
            
            nums[i] = nums[dq.peekFirst()] + nums[i];

            // Add nums[i] to our deque
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast(); // Eliminate elements less or equal to nums[i], which will never be chosen in the future
            dq.offerLast(i);

            // Remove if the last element is out of window size k
            if (i - dq.peekFirst() >= k) dq.pollFirst();
            // System.out.println(Arrays.toString(nums)+"\n"+dq+"\n\n");
        }
        return nums[n - 1];
     }
}