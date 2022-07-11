class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] :  edges[0][1];
        // int n = edges.length;
        // int[] degree = new int[n+2];
        // for (int[] edge: edges){
        //     degree[edge[0]] += 1;
        //     degree[edge[1]] += 1;
        // }
        // // System.out.println(n+" " +Arrays.toString(degree));
        // for(int i = 1; i <=n+1; i++){
        //     if(degree[i] == n)
        //         return i;
        // }
        // return 1;
    }
}