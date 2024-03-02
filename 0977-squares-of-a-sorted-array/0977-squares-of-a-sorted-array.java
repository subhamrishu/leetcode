class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n];
        
        int minIdx = 0;
        
        for (int i = 1; i < n; i++){
            if (Math.abs(nums[minIdx]) > Math.abs(nums[i]))
                minIdx = i;
        }
        sol[0] = nums[minIdx]*nums[minIdx];
        int i = minIdx - 1, j = minIdx + 1, k = 1;
        while (i >= 0 || j < n){
            if (i >= 0 && j < n){
                if (Math.abs(nums[i]) < Math.abs(nums[j]))
                    sol[k++] = nums[i] * nums[i--];
                else
                    sol[k++] = nums[j] * nums[j++];
            }else if(i < 0){
                while (j < n){
                    sol[k++] = nums[j] * nums[j++];
                }
            }else{
                while(i >= 0){
                    sol[k++] = nums[i] * nums[i--];
                }
            }
        }
        return sol;
    }
}