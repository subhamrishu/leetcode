class Solution {
    public int[] findOriginalArray(int[] changed) {
        /* Old Solution
        Map<Integer, Integer> map = new HashMap<>();
        // Arrays.sort(changed);
        int n = changed.length;
        if (n%2 == 1)
            return new int[0];
        int maxNum = -1;
        for (int num: changed){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
            maxNum = Math.max(num, maxNum);
        }
        
        int[] res = new int[(int)n/2];
        int index = 0;
        for (int key = 0; key <= maxNum; key++){
            // System.out.println(key);
            while(map.containsKey(key) && map.get(key) > 0){
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
        return res;
        */
        int n = changed.length;
        if (n%2 == 1)
            return new int[0];
        int maxNum = -1;
        for (int num: changed){
            maxNum = Math.max(num, maxNum);
        }
        int[] freq = new int[2*maxNum + 1];
        for (int num: changed){
            freq[num]++;
        }
        int[] res = new int[n/2];
        int index = 0;
        for (int num = 0; num <= maxNum; num++){
            while (freq[num] > 0){
                freq[num]--;
                int doubled = num * 2;
                if (freq[doubled] > 0){
                    freq[doubled]--;
                    res[index++] = num;
                }
                else
                    return new int[0];
            }
        }
        return res;
    }
}