class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[123];
        for (char ch: s.toCharArray()){
            freq[ch]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for (int i = 0; i < 123; i++){
            if (freq[i] != 0){
                pq.add(new int[]{i, freq[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            char ch = (char)temp[0];
            for (int i =0; i < temp[1]; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}