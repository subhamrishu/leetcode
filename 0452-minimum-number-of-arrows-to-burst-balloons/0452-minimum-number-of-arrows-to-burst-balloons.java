class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        // System.out.println(Arrays.deepToString(points));
        int n = points.length;
        int i = 0, cnt = 0;
        while (i < n){
            // int p = i;
            int max = points[i][1];
            while((i+1)<n && max >= points[i+1][0]){
                max = Math.min(max, points[i+1][1]);
                i++;
                // System.out.println("p = "+p+" i = "+i);
            }
            cnt++;
            i++;
        }
        return cnt;
    }
}