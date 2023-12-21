class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> map = new HashMap<>();
        int N = n;
        while (N > 0){
            int[] cells2 = new int[8];
            map.put(Arrays.toString(cells), N--);
            for (int i = 1; i < 7; i++){
                cells2[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            }
            cells = cells2;
            if (map.containsKey(Arrays.toString(cells))){
                N = N % (map.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}