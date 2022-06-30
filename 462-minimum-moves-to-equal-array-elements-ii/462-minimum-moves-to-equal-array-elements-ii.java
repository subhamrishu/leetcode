class Solution {
    void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    int partition(int nums[], int start, int end){
        int pivotIndex = start + (int)(Math.random() * (end - start + 1));
        int pivot = nums[pivotIndex], i = start - 1;;
        swap(nums, pivotIndex, end);
       

        for(int j = start; j < end; j++){
            if (nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, end);
        return i+1;

    }
    
    int QuickSelect(int nums[], int start, int end, int k){
        
        if(start == end)
            return nums[start];
        int pivotIndex = partition(nums, start, end);
        
        if (pivotIndex == k)
            return nums[pivotIndex];
        else if(pivotIndex < k)
            return QuickSelect(nums, pivotIndex + 1, end, k);
        else
            return QuickSelect(nums, start, pivotIndex -1, k);
    }
    public int minMoves2(int[] nums) {
        int mid = nums.length / 2;
        int median = QuickSelect(nums, 0, nums.length-1, mid);
        // System.out.println(median);
        int sum = 0;
        for (int i = 0; i< nums.length; i++){
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }
}