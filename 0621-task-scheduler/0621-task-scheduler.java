class Solution {
    // class Task{
    //     char task;
    //     int remTime;
    //     Task(char task, int remTime){
    //         this.task = task;
    //         this.remTime = remTime;
    //     }
    // }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++){
            if (freq[i] != 0)
                pq.add(freq[i]);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()){
            time += 1;
            if (!pq.isEmpty()){
                int curr = pq.poll();
                
                if (curr != 1){
                    q.add(new int[]{curr-1, time+n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
            
        }
        return time;
    }
}