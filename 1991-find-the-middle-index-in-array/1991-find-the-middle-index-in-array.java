class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
        }
        // System.out.println(Arrays.toString(lr));
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++){
            // System.out.println(i+" "+leftSum+" "+(lr[i]-nums[i]));
            if (leftSum == sum-nums[i]-leftSum){
                return i;
            }else{
                leftSum += nums[i];
            }
        }
        return -1;
    }
}