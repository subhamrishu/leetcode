class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();
        // Pair<Integer,List<Integer>> pair = new Pair<>();

        PriorityQueue<Pair<Integer,List<Integer>>> maxHeap = new PriorityQueue<>((a, b)->(b.getKey() - a.getKey()));
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int sum = nums1[i] + nums2[j];
                if (maxHeap.size() < k){
                    maxHeap.add(new Pair(sum, new ArrayList(Arrays.asList(nums1[i], nums2[j]))));
                }
                else if (maxHeap.peek().getKey() > sum){
                    maxHeap.poll();
                    maxHeap.add(new Pair(sum, new ArrayList(Arrays.asList(nums1[i], nums2[j]))));
                }
                else
                    break;
            }
        }
        while (k > 0 && !maxHeap.isEmpty()){
            
            ans.add(0, maxHeap.poll().getValue());
            k--;
        }
        return ans;
        
    }
}