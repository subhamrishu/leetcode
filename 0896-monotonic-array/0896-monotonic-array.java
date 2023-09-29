class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;
        int i = 0;
        while (i < n-1 && nums[i] == nums[i+1]){
            i++;
        }
        if (i == n-1) return true;
        boolean increasing = nums[i+1] - nums[i] >= 0 ? true : false;
        
        for (int j = i; j < n-1; j++){
            if (increasing && nums[j+1] < nums[j] || !increasing && nums[j+1] > nums[j]) return false;
           
        }
        return true;
    }
}