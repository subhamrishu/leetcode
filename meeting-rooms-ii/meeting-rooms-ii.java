class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i = 0; i < intervals.length; i++){
            if (!pq.isEmpty() && pq.peek() <= intervals[i][0]){
                pq.poll();
                
            } else{
                count++;
                
            }
            pq.offer(intervals[i][1]);
        }
        return count;
    }
}