class Solution {
    /* Priority Queue - TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return new int[] {nums[0]};
        int n = nums.length;
        int sol[] = new int[n-k+1];
        int ind = 0,i = 0, j = 0, max = Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        while(i < n-k+1){
            pq.add(nums[j]);
            if(j-i+1 == k){
                sol[ind++] = pq.peek();
                pq.remove(nums[i]);
                i++;
            }
            j++;
        }
        return sol;
    }
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1)
            return new int[] {nums[0]};
        if (k == n){
            int max = Integer.MIN_VALUE;
            for (int num: nums){
                max = Math.max(max, num);
            }
            return new int[] {max};
        }
        int sol[] = new int[n-k+1];
        
        int ind = 0, i = 0, j = 0;
        Deque<Integer> dq = new ArrayDeque();
        while(j < n){
            while (dq.size() > 0 && nums[j] > dq.peekLast()) 
                dq.pollLast();
            // while (dq.size() > 0 && nums[i] < )
            dq.offerLast(nums[j]);
            if (j-i+1 == k){
                // System.out.println(nums[i]+" "+nums[j]+" "+dq);
                sol[ind++] = dq.peekFirst();
                if (nums[i] == dq.peekFirst())
                    dq.pollFirst();
                i++;
            }
            
            j++;
        }
        return sol;
    }
}