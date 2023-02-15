class Solution {
    long fuelcost = 0;
    long dfs(int node, int parent, Map<Integer, ArrayList<Integer>> adjList, int seats){
        long subNodes = 1;
        if (!adjList.containsKey(node))
            return subNodes;
        for (int child : adjList.get(node)){
            if (child != parent){
                subNodes += dfs(child, node, adjList, seats);
            }
        }
        if (node != 0)
            fuelcost += Math.ceil((double)subNodes/seats);
        return subNodes;
        
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i = 0; i<roads.length; i++){
            int x = roads[i][0];
            int y = roads[i][1];
            adjList.putIfAbsent(x, new ArrayList<Integer>());
            adjList.putIfAbsent(y, new ArrayList<Integer>());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }
        // int fuelCost = 0;
        dfs(0, -1, adjList, seats);
        return fuelcost;
    }
}