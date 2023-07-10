class Solution {
    class Points{
        int[] vertices;
        double distance;
        Points(int[] p){
            vertices = p;
            distance = Math.sqrt(p[0]*p[0] + p[1]*p[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> pq = new PriorityQueue<Points>(new Comparator<Points>(){
           public int compare(Points p1, Points p2){
               if(p2.distance < p1.distance){
                  return -1;
               }
               else{
                  return 1;
               }
           }
        });
        for (int[] point: points){
            pq.add(new Points(point));
            if (pq.size() > k){
                pq.poll();
            }
        }
        int[][] sol = new int[k][];
        for (int i = 0; i < k; i++){
            sol[i] = pq.poll().vertices;
        }
        return sol;
    }
}