class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length-2; i++){
            int a = nums[i], j = i+1, k = n-1;
            while (j < k){
                int sum = (a + nums[j] + nums[k]);
                if (Math.abs(target-sum) < Math.abs(minDiff)){
                    minDiff = target - sum;
                }
                if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return target - minDiff;
    }
}