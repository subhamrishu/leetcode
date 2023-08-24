class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num: nums){
            int other = k - num;
            if (map.containsKey(other) && map.get(other) > 0){
                count++;
                map.put(other, map.get(other)-1);
            }
            else{
                map.putIfAbsent(num, 0);
                map.put(num, map.get(num)+1);
            }
        }
        return count;
    }
}