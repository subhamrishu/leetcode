class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> sol = new ArrayList<>();
        int i = 0;
        while (i< n && newInterval[0] > intervals[i][1]){
            sol.add(intervals[i++]);
        }
        while (i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        sol.add(newInterval);
        while (i < n){
            sol.add(intervals[i++]);
        }
        int[][] ans = new int[sol.size()][2];
        for (int j = 0; j < sol.size(); j++){
            ans[j] = sol.get(j);
        }
        return ans;
    }
}