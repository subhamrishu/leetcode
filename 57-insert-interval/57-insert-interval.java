class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int len = intervals.length;
        if (len < 1)
            return new int[][] {newInterval};
        int end = Math.max(intervals[len-1][1], newInterval[1]);
        
        int[] arr = new int[end+1];
        for (int i = 0;i<end+1;i++)
            arr[i]=-1;
        for (int[] interval: intervals){
            for (int i = interval[0]; i<=interval[1];i++){
                arr[i] = interval[1];
            }
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = newInterval[0]; i<=newInterval[1]; i++){
            arr[i] = Math.max(newInterval[1], arr[i]);
        }
        // System.out.println(Arrays.toString(arr));
        List<int[]> solution = new ArrayList();

        int i = 0;
        while (i <= end){
            int start = i;
            while (arr[i] != i && arr[i]>i){
                i = arr[i];
            }
            if (arr[i]!=-1)
                solution.add(new int[] {start, i});
            i+=1;
        }
        return solution.toArray(new int[solution.size()][]);
    }
}