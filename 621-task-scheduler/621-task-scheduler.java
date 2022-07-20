class Solution {
    class Task{
        int count;
        int timeLeftToProcess;
        Task(int c, int t){
            count = c;
            timeLeftToProcess = t;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (char ch = 'A'; ch <= 'Z'; ch++){
            if (freq[ch - 'A'] != 0)
                pq.offer(freq[ch-'A']);
        }
        Queue<Task> q = new LinkedList();
        int time = 0;
        while (pq.size()!=0 || q.size()!= 0){
            time+= 1;
            if (pq.size()!=0){
                int currCount = pq.poll() - 1;
                if (currCount != 0){
                    q.offer(new Task(currCount, time+n));
                }
            }
            if (q.size()!=0 && q.peek().timeLeftToProcess == time){
                pq.offer(q.poll().count);
            }
        }
        return time;
    }
}