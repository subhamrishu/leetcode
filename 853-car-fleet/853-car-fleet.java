class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1)
            return 1;
        
        int[] road = new int[target];
        for (int i = 0; i< n; i++){
            road[position[i]] = speed[i];
        }
        int sol = 0;
        double slowest = Double.MIN_VALUE;
        for (int i = target-1; i >=0; i--){
            if (road[i] > 0){
                double time = (double)(target - i)/road[i];
                if (slowest < time){
                    sol++;
                    slowest = time;
                }
            }
        }
        return sol;
    }
}