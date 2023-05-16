class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            k, (a, b) -> map.get(b) - map.get(a));
        for (int key: map.keySet()){
            pq.offer(key);
        }
        int[] sol = new int[k];
        for (int i = 0; i < k; i++){
            sol[i] = pq.poll();
        }
        return sol;
    }
}