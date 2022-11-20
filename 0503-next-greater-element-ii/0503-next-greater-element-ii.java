class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int top = -1;
        int[] stack = new int[n*2];
        for(int i = n-1; i >= 0; i--){
            stack[++top] = i;
        }
        int[] result = new int[n];
        for (int i = n-1; i >= 0; i--){
            result[i] = -1;
            while (top >=0. && nums[stack[top]] <= nums[i]){
                top--;
            }
            if (top != -1)
                result[i] = nums[stack[top]];
            stack[++top] = i;
        }
        return result;
    }
}