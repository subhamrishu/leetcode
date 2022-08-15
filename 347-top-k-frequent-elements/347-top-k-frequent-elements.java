
class Solution {
    class Pair{
        int key, value;
        Pair(int k, int v){
            key = k;
            value=v;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int num: nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
        }
        // PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Integer>(){
        //     public int compare(Pair a, Pair b){
        //         if (a.value < b.value) return 1;
        //         if (a.value == b.value) return 0;
        //         else return -1;
        //     }
        // });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.value, a.value));
        for (int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }
        int[] sol = new int[k];
        for (int i = 0; i < k; i++){
            sol[i] = pq.poll().key;
        }
        return sol;
    }
}