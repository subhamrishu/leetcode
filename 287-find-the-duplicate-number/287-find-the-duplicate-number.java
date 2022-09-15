class Solution {

    public int findDuplicate(int[] nums) {
        /* Method 1- Sorting - 62ms - 6.88% faster
        Arrays.sort(nums);
        for (int i  = 1 ; i < nums.length; i++){
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
        */
        /*Method 2 - HashSet - 67ms - 5.26% faster 
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums){
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
        */
        /* Method 3 - Negative Marking */
        
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                return Math.abs(nums[i]);
            nums[index] = -1 * nums[index];
        }
        return -1;
    }
}