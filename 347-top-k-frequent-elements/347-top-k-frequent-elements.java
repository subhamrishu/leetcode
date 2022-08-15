
class Solution {
    // class Pair{
    //     int key, value;
    //     Pair(int k, int v){
    //         key = k;
    //         value=v;
    //     }
    // }
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap<Integer, Integer> map = new HashMap();
        // for (int num: nums){
        //     map.putIfAbsent(num, 0);
        //     map.put(num, map.get(num)+1);
        // }
        // // PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Integer>(){
        // //     public int compare(Pair a, Pair b){
        // //         if (a.value < b.value) return 1;
        // //         if (a.value == b.value) return 0;
        // //         else return -1;
        // //     }
        // // });
        // PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.value, a.value));
        // for (int key : map.keySet()){
        //     pq.add(new Pair(key, map.get(key)));
        // }
        // int[] sol = new int[k];
        // for (int i = 0; i < k; i++){
        //     sol[i] = pq.poll().key;
        // }
        // return sol;
        
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> bucket = new ArrayList();
        
        for (int i = 0 ; i < nums.length+1; i++){
            bucket.add(new ArrayList());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            bucket.get(value).add(key);
        }
        // List<Integer> sol = new ArrayList<Integer>();
        int[] sol = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--){
            List<Integer> l = bucket.get(i);
            for (int key : l){
                sol[j++] = key;
                if (j == k)
                    return sol;
            }
        }
        // int j = nums.length, i = 0;
        // while (k!=0){
        //     if (bucket[j] != null){
        //         sol[i++] = bucket[j];
        //         k--;
        //     }
        //     j--;
        // }
        return sol;
    }
}