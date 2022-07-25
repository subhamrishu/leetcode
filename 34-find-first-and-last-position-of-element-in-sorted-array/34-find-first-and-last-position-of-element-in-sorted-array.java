class Solution {
   int lowerBound(int nums[], int target){
        int low = 0, high = nums.length-1;
        int flag = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid] == target){
                flag = mid;
                high = mid-1;
            }
            else if (nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return flag;
    }
    int upperBound(int nums[], int target){
        int low = 0, high = nums.length-1;
        int flag = -1;
        while (low <=high){
            int mid = (low + high)/2;
            if (nums[mid] == target){
                flag = mid;
                //System.out.print(flag + " ");
                low =mid+1;
            }
            else if (nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return flag;
    }
    public int[] searchRange(int[] nums, int target) {
        
        return new int[] {lowerBound(nums, target), upperBound(nums, target)};
    }
}