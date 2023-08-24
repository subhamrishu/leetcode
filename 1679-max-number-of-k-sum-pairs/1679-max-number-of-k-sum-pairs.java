class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right){
            long sum = nums[left] + nums[right];
            if (sum == k){
                count++;
                left++; right--;
            }else if (sum < k){
                left++;
            }
            else
                right--;
        }
        return count;
    }
}