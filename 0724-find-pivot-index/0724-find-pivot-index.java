class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] lr = new int[n+1];
        // int[] rl = new int[n+1];
        lr[n] = 0;
        for (int i = nums.length - 1; i >= 0; i--){
            lr[i] += lr[i+1] + nums[i];
        }
        // System.out.println(Arrays.toString(lr));
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++){
            // System.out.println(i+" "+leftSum+" "+(lr[i]-nums[i]));
            if (leftSum == lr[i]-nums[i]){
                return i;
            }else{
                leftSum += nums[i];
            }
        }
        return -1;
    }
}