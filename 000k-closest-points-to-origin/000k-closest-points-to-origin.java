class Solution {
    double euclideanDistance(int[] p){
        double x = Math.pow(p[0], 2);
        double y = Math.pow(p[1], 2);
        
        return Math.sqrt(x+y);
    }
    public int[][] kClosest(int[][] points, int k) {
        double[] distance = new double[points.length];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Double.compare(distance[b], distance[a]));
        for (int i = 0; i < points.length; i++){
            distance[i] = euclideanDistance(points[i]);
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] sol = new int[k][2];
        for (int i = 0; i < k; i++){
            sol[i] = (points[pq.poll()]);
        }
        return sol;
        
    }
}