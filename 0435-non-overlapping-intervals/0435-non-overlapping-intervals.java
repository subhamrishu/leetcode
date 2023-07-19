class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int k = intervals[0][1];
        for (int i = 1; i < n; i++){
            if (k <= intervals[i][0]){
                k = intervals[i][1];
                count++;
            }
        }
        // System.out.println(Arrays.deepToString(intervals));
        return n-count-1;
    }
}