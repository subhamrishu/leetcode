class Solution {
    List<Integer> getPair(int a, int b){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        return l;
    }
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int n = intervals.length;
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (intervals[i][0] >= toBeRemoved[0] && intervals[i][1] <= toBeRemoved[1])
                continue;
            if (intervals[i][0] < toBeRemoved[0] && intervals[i][1] > toBeRemoved[0]){
                sol.add(getPair(intervals[i][0], toBeRemoved[0]));
            }
            if (intervals[i][1] > toBeRemoved[1] && intervals[i][0] <= toBeRemoved[1]){
                sol.add(getPair(toBeRemoved[1], intervals[i][1]));
            }
            if (intervals[i][1] <= toBeRemoved[0] || intervals[i][0] > toBeRemoved[1])
                sol.add(getPair(intervals[i][0], intervals[i][1]));
        }
        return sol;
    }
}