class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length, ind = 0;
        int[] sol = new int[n-k+1];
        for (int i = 0; i < n; i++){
            if(dq.size()!=0 && dq.peek() == i-k)
                dq.removeFirst();
            while(dq.size()!=0 && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            if (i-k+1 >=0)
                sol[ind++] = nums[dq.peekFirst()];
        }
        return sol;
    }
}