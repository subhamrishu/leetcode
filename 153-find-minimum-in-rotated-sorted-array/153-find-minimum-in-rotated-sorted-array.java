class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high){
            int mid = low + (high-low)/2;
            // System.out.println("low = "+low+" mid= "+mid+" high="+high);
            if (nums[low] <= nums[mid] && nums[mid] < nums[high]){//low...high is sorted
                high = mid - 1;
            }
            else if (nums[low] <= nums[mid] && nums[mid] > nums[high]){//right side of mid contains lesser element
                low = mid + 1;
            }
            else if (nums[low] > nums[mid]){
                low = low + 1;
                high = mid;
            }
        }
        return nums[low];
    }
}