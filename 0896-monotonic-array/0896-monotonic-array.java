class Solution {
    boolean isMonotonicIncreasing(int[] nums){
        int i  = 1, n = nums.length;
        while (i < n &&  nums[i-1] <= nums[i])
            i++;
        return (i == n);
    }
    boolean isMonotonicDecreasing(int[] nums){
        int i = 1, n = nums.length;
        while (i < n && nums[i-1] >= nums[i])
            i++;
        return (i==n);
    }
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;
        if (isMonotonicIncreasing(nums))
            return true;
        if (isMonotonicDecreasing(nums))
            return true;
        return false;
    }
}