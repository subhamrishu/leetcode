class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> sol = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), new int[2]);
                map.get(s.charAt(i))[0] = i;
                // map.get(s.charAt(i))[1] = i;
            }
            map.get(s.charAt(i))[1] = i;
        }
        int j, max;
        for (int i = 0; i < s.length(); i++){
            j = i;
            max = map.get(s.charAt(i))[1];
            while (i < max){
                max = Math.max(max, map.get(s.charAt(i))[1]);
                i++;
            }
            sol.add(max-j+1);
        }
        return sol;
    }
}