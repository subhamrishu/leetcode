class Solution {
    private int dfs(int head, Map<Integer, ArrayList> graph, int[] informTime){
        if (informTime[head] == 0)
            return 0;
        int max = 0;
        ArrayList<Integer> curr = graph.get(head);
        for (int emp: curr){
            max = Math.max(max, dfs(emp, graph, informTime));
        }
        return max + informTime[head];
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, ArrayList> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++){
            if(i != headID){
                graph.putIfAbsent(manager[i], new ArrayList<Integer>());
                graph.get(manager[i]).add(i);
            }
        }
        return dfs(headID, graph, informTime);
//         Queue<Integer> q = new LinkedList<>();
//         if (graph.containsKey(headID))
//             q.add(headID);
//         int totalTime = 0;
//         // totalTime += informTime[headID];
//         while(!q.isEmpty()){
            
//             int currSize = q.size();
//             int max = 0;
//             for (int i = 0; i < currSize; i++){
//                 int currEmp = q.poll();
//                 max = Math.max(max, informTime[currEmp]);
//                 ArrayList<Integer> curr = graph.get(currEmp);
//                 for (int emp: curr){
//                     if(informTime[emp] != 0){
//                         // totalTime += informTime[emp];
//                         q.add(emp);
//                     }
//                 }
//             }
//             totalTime += max;
//         }
//         return totalTime;
        // return 0;
    }
}