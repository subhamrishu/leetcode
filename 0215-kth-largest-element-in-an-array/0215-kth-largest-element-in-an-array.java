class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int partition(int[] nums, int lo, int hi){
        int pivot = nums[hi];
        int i = lo-1, j = lo;
        while (j < hi){
            if (nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
            j++;
        }
        swap(nums, i+1, hi);
        return i+1;
    }
    int quickSelect(int[] nums, int k){
        int n = nums.length;
        k = n-k;
        int lo = 0, hi = n-1;
        while (lo < hi){
            int pivot = partition(nums, lo, hi);
            // System.out.println(pivot);
            if (pivot < k)
                lo = pivot +1;
            else if (pivot > k)
                hi = pivot - 1;
            else
                break;
        }
        // System.out.println(Arrays.toString(nums)+" lo="+lo+" hi="+hi);
        return nums[k];
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k);
    }
}