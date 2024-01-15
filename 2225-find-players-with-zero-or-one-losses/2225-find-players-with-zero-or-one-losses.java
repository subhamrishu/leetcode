class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> sol = new ArrayList<>();
        
        // Map<Integer, Integer> map = new TreeMap<>();
        int[] freq = new int[100001];
        
        for (int i = 0; i < matches.length; i++){
            int win = matches[i][0];
            int loss = matches[i][1];
            // map.put(matches[i][0], map.getOrDefault(matches[i][0], 0));
            // map.put(matches[i][1], map.getOrDefault(matches[i][1], 0)+1);
            if (freq[win] == 0)
                freq[win] = -1;
            if (freq[loss] == -1)
                freq[loss] = 1;
            else
                freq[loss]++;
        }
        List<Integer> l= new ArrayList<>();
        List<Integer> w = new ArrayList<>();
        
        
        // for (int key: map.keySet()){
        //     int val = map.get(key);
        //     if (val == 0)
        //         w.add(key);
        //     else if (val == 1)
        //         l.add(key);
        // }
        for (int i = 1; i < freq.length; i++){
            if (freq[i] == -1)
                w.add(i);
            if (freq[i] == 1)
                l.add(i);
        }
        sol.add(w);
        sol.add(l);
        return sol;
    }
}