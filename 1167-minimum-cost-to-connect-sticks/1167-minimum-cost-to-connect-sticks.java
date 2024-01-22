class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int stick: sticks){
            pq.add(stick);
        }
        int cost = 0;
        while (pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            cost += (a+b);
            pq.add(a+b);
        }
        return cost;
    }
}