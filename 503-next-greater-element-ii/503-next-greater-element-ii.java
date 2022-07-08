class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n*2];
        
        for (int i=0;i<n;i++){
            nums2[i] = nums[i];
            nums2[i+n] = nums[i];
        }
        
        Stack<Integer> stack = new Stack();
        int[] nextGreater = new int[n];
        for (int i =0;i<n; i++){
            nextGreater[i] = -1;
        }
        
        for(int i = 0; i< nums2.length; i++){
            while (!stack.empty() && nums2[stack.peek()] < nums2[i]){
                nextGreater[stack.pop()%n] = nums2[i];
            }
            stack.push(i);
        }
        
        return nextGreater;
    }
}