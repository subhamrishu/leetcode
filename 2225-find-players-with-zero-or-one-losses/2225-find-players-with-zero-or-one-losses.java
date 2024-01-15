class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> sw = new TreeSet<>();
        Set<Integer> sl = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < matches.length; i++){
            sl.add(matches[i][1]);
            if (sl.contains(matches[i][0])){
                sw.remove(matches[i][0]);
            }else{
                sw.add(matches[i][0]);
            }
            if (sw.contains(matches[i][1])){
                sw.remove(matches[i][1]);
            }
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0)+1);
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> w = new ArrayList<>(sw);
        
        for (int k: sl){
            if(map.get(k) == 1){
                l.add(k);
            }
        }
        List<List<Integer>> sol = new ArrayList<>();
        
        sol.add(w);
        sol.add(l);
        
        return sol;
    }
}