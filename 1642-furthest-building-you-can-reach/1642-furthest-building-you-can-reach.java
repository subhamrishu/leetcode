class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if (n == 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for(int i = 1; i < n; i++){
            int diff = heights[i] - heights[i-1];
            if (diff <= 0){
                index++;
                continue;
            }
            
            pq.offer(diff);
            
            if (pq.size() > ladders){
                if (bricks >= pq.peek()){
                    bricks-= pq.poll();
                    index++;
                }else
                    break;
            }
                
            
        }
        index += ladders;
        return index >= n ? n - 1 : index;
    }
}