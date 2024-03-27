class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n-2; i++){
            int j = i+1, k = n-1;
            
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target-sum) < Math.abs(minDiff)){
                    minDiff = target-sum;
                }
                if (sum < target) j++;
                else k--;
            }
        }
        return target-minDiff;
    }
}