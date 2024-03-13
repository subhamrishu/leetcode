class Solution {
    public int openLock(String[] deadends, String target) {
        String currCombination = "0000";
        Map<Character, Character> frontMap = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> backMap = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );
        
        Queue<String> q = new LinkedList<>();
        q.add(currCombination);
        
        Set<String> set = new HashSet<>();
        
        for (String deadend: deadends){
            set.add(deadend);
        }
        
        if (set.contains("0000"))
            return -1;
        set.add(currCombination);
        int turns = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int k = 0; k < size; k++){
                currCombination = q.poll();
                StringBuilder sb;
                if (currCombination.equals(target))
                    return turns;
                for (int wheel = 0; wheel < 4; wheel++){
                    sb = new StringBuilder(currCombination);
                    sb.setCharAt(wheel, frontMap.get(currCombination.charAt(wheel)));
                    if (!set.contains(sb.toString())){
                        set.add(sb.toString());
                        q.add(sb.toString());
                    }
                    sb = new StringBuilder(currCombination);
                    sb.setCharAt(wheel, backMap.get(sb.charAt(wheel)));
                    if (!set.contains(sb.toString())){
                        set.add(sb.toString());
                        q.add(sb.toString());
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}