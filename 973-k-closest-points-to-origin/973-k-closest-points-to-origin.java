class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /* ------------------- O (n*n) ---------------
        int[][] pointsAndDistance = new int[points.length][2];
        
        for (int i = 0; i < points.length; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pointsAndDistance[i] = new int[] {distance, i};
        }
        Arrays.sort(pointsAndDistance, (a,b) -> a[0] - b[0]);
        // System.out.println(Arrays.deepToString(pointsAndDistance));
        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++){
            int p = pointsAndDistance[i][1];
            sol[i] = new int[] {points[p][0], points[p][1]};
        }
        return sol;
        */
        /* ---------------Max Heap ------------------*/
        PriorityQueue<int[]> pq = new PriorityQueue<int []>((p1, p2) -> p2[0]*p2[0] + p2[1]*p2[1] - p1[0]*p1[0] - p1[1]*p1[1]);
        
        for (int[] p: points){
            pq.offer(p);
            if (pq.size() > k){
                pq.poll();
            }
        }
        int sol[][] = new int[k][2];
        
        while(k > 0){
            sol[--k] = pq.poll();
        }
        return sol;
    }
}