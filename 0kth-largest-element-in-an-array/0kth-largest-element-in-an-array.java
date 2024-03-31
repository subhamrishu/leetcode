class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int partition(int[] nums, int lo, int hi, int idx){
        int pivot = nums[idx];
        swap(nums, idx, hi);
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
        k = n - k;

        int lo = 0, hi = n - 1;
        while (lo < hi){
            int pIndex = new Random().nextInt(hi - lo + 1) + lo;
            int pivot = partition(nums, lo, hi, pIndex);

            if (pivot < k)
                lo = pivot + 1;
            else if (pivot > k)
                hi = pivot - 1;
            else 
                break;
        }
        return nums[k];
    }
    public int findKthLargest(int[] nums, int k) {
         return quickSelect(nums, k);
    }
}