class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[1], b[1]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++){
            list.add(new int[]{nums1[i], nums2[i]});
        }
        Collections.sort(list, (a, b)-> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b)->a-b); //min heap
        long topKSum = 0;
        for (int i = 0; i < k; i++){
            topKSum += list.get(i)[0];
            pq.add(list.get(i)[0]);
        }
       long max = topKSum * list.get(k-1)[1];
        for (int i = k; i < nums2.length; i++){
            topKSum += list.get(i)[0] - pq.poll();
            pq.add(list.get(i)[0]);
            max = Math.max(max, topKSum * list.get(i)[1]);
        }
        
        return max;
    }
}