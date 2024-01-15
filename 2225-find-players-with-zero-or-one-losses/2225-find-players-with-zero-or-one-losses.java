class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> sol = new ArrayList<>();
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < matches.length; i++){
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0)+1);
        }
        List<Integer> l= new ArrayList<>();
        List<Integer> w = new ArrayList<>();
        
        
        for (int key: map.keySet()){
            int val = map.get(key);
            if (val == 0)
                w.add(key);
            else if (val == 1)
                l.add(key);
        }
        sol.add(w);
        sol.add(l);
        return sol;
    }
}