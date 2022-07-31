class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right =n-1;
        int[] sol = new int[n];
        int ind = n-1;
        while (left <= right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq){
                sol[ind--] = leftSq;
                left++;
            }
            else{
                sol[ind--] = rightSq;
                right--;
            }
        }
        return sol;
    }
}