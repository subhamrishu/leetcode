class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int n = costs.length;
        for (int i =0 ; i < candidates; i++){
            pq1.add(costs[i]);
            if (i < n-candidates)
                pq2.add(costs[n-i-1]);
        }
        // for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
        //     pq2.add(costs[i]);
        // }
        long cost = 0;
        int l = candidates, j = n-candidates-1;
        for (int i =0 ; i <k ; i++){
            if (pq2.isEmpty() || !pq1.isEmpty() && pq1.peek() <= pq2.peek()){
                cost += pq1.poll();
                if(l < n && l <= j)
                    pq1.add(costs[l++]);
            }
            else {
                cost += pq2.poll();
                if(j >= 0 && j >= l)
                    pq2.add(costs[j--]);
            }
            // System.out.println(cost);
        }
        return cost;
    }
}