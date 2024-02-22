class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] trustCount = new int[n+1][2];
        if (n == 1) return 1;
        int judge = 0;
        for (int i = 0; i < trust.length; i++){
            int other = trust[i][1];
            trustCount[other][0]++;
            trustCount[trust[i][0]][1] = other;
            if (trustCount[other][0] == n-1)
                judge = other;
        }
        if (trustCount[judge][1] == 0 && judge != 0)
            return judge;
        return -1;
    }
}