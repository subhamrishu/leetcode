class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(changed);
        int n = changed.length;
        if (n%2 == 1)
            return new int[0];
        
        for (int num: changed){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
        }
        
        int[] res = new int[(int)n/2];
        int index = 0;
        for (int key: changed){
            // System.out.println(key);
            while(map.get(key) > 0){
                int doubled = key * 2;
                map.put(key, map.get(key)-1);
                if (map.containsKey(doubled) && map.get(doubled) > 0){
                    map.put(doubled, map.get(doubled)-1);
                    res[index++] = key;
                }
                else
                    return new int[0];
            }
            
        }
        for(int key: map.keySet()){
            if (map.get(key) > 0)
                return new int[0];
        }
        return res;
    }
}