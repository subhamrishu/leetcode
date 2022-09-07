class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if (nums[mid] == target)
                return mid;
            
            //left sorted portion
            if (nums[low] <= nums[mid]){
                if (nums[mid] < target || target < nums[low])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else { //right sorted portion
                if (target < nums[mid] || nums[high] < target)
                    high = mid -1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
}