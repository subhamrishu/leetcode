class Solution {
    int distance(int[][] points, int src, int dest){
        if (points[src][0] == points[dest][0]){
            return Math.abs(points[dest][1] - points[src][1]);
        }
        else if (points[src][1] == points[dest][1]){
             return Math.abs(points[dest][0] - points[src][0]);
        }
        
        return Math.max(Math.abs(points[dest][0] - points[src][0]), Math.abs(points[dest][1] - points[src][1]));
        // return Math.abs(points[dest][0] - points[src][0] + points[dest][1] - (points[src][1] + (points[dest][0] - points[src][0])));
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 1; i < points.length; i++){
            ans += distance(points, i-1, i);
        }
        return ans;
    }
}