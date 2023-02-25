class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer>maxQ = new PriorityQueue<>((a,b) -> (b - a));
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 1)
                nums[i] = nums[i]*2;
            maxQ.add(nums[i]);
            // max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int minDeviation = Integer.MAX_VALUE;
        while(maxQ.peek() % 2 == 0){
            int max = maxQ.poll();
            minDeviation = Math.min(minDeviation, max-min);
            min = Math.min(min, max/2);
            maxQ.add(max/2);
        }
        return minDeviation < maxQ.peek() - min ? minDeviation : maxQ.peek() - min;
    }
}