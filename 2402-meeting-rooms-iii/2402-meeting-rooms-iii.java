class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0] - b[0]);
        int[] count = new int[n];
        // System.out.println(Arrays.deepToString(meetings));
        // Comparator<long[]> myComparator = new Comparator<>(){
        //     public long compare(long[] a, long[] b){
        //         long diff = Long.compare(a[1], b[1]);
        //         if (diff == 0){
        //             return Long.compare(a[0], b[0]);
        //         }
        //         return diff;
        //     }
        // };
        PriorityQueue<long[]> occupied = new PriorityQueue<>((a, b) -> a[1] != b[1] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        PriorityQueue<Integer> free = new PriorityQueue<>();
        
        int[] meeting = new int[n];
        
        for (int i = 0; i < n; i++){
            free.offer(i);
        }
        
        for (int i = 0; i < meetings.length; i++){
            // int[] curr = pq.poll();
            int start= meetings[i][0];
            int end = meetings[i][1];
            
            while (!occupied.isEmpty() && occupied.peek()[1] <= start){
                free.offer((int)occupied.poll()[0]);
            }
            // System.out.println(free);
            if (!free.isEmpty()){
                int room = free.poll();
                occupied.offer(new long[]{room, end});
                count[room]++;
            }else{
                long[] temp = occupied.poll();
                long time = temp[1];
                int room = (int)temp[0];
                occupied.offer(new long[]{room, time+end-start});
                count[room]++;
            }
            
            // if (curr[1] <= meetings[i][0]){
            //     pq.offer(new int[]{curr[0], meetings[i][1]});
            // }
            // else {
            //     pq.offer(new int[]{curr[0], curr[1] + meetings[i][1] - meetings[i][0]});
            // }
            
        }
        int[] sol = new int[2];
        
        for (int i = 0; i < n; i++){
            if (count[i] > sol[1]){
                sol[0] = i;
                sol[1] = count[i];
            }
        }
        return sol[0];
        
        // return 0;
    }
}