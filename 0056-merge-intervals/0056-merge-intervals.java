class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        List<int[]> sol = new ArrayList<>();
        
        int n = intervals.length;
        int i = 0, j = 0;
        while (i < n && j < n){
            while (i< n-1 && intervals[i][1] < intervals[i+1][0])
                sol.add(intervals[i++]);
            j = i;
            int b = intervals[i][1];
            while (j < n && b >= intervals[j][0]){
                b = Math.max(intervals[j][1], b);
                j++; 
            }
            sol.add(new int[] {intervals[i][0], b});
            i = j;
            
        }
        int[][] ans = new int[sol.size()][2];
        for (i = 0; i < sol.size(); i++){
            ans[i] = sol.get(i);
        }
        return ans;
    }
}