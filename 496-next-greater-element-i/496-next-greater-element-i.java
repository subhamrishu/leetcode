class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> nextGreater = new HashMap();
        for (int i = 0; i < nums2.length; i++){
            while (!stack.empty() && nums2[stack.peek()] < nums2[i]){
                int ind = stack.pop();
                nextGreater.put(nums2[ind], nums2[i]);//[nums2[ind]] = nums2[i];
            }
            stack.push(i);
        }
        // System.out.println(Arrays.toString(nextGreater));
        int ans[] = new int[nums1.length];
        for (int i = 0; i<nums1.length; i++){
            if (nextGreater.containsKey(nums1[i]))
                ans[i] = nextGreater.get(nums1[i]);
            else
                ans[i] = -1;
        }
        return ans;
    }
}