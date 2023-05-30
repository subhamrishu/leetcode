class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<int[]> list = new ArrayList<>();
        int n = position.length;
        for (int i = 0; i < n; i++){
            list.add(new int[]{position[i], speed[i]});
        }
        list.sort((a, b) -> b[0] - a[0]);
        double[] rt = new double[n];
        for (int i = 0; i < n; i++){
            rt[i] = (target - list.get(i)[0]) * 1.0/list.get(i)[1];
        }
        int fleet = 1;
        double max = rt[0];
        for (int i = 1; i < n; i++){
            if (max < rt[i]){
                max = rt[i];
                fleet += 1;
            }
        }
        return fleet;
    }
}