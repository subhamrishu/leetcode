// class SortByCapital implements Comparator<List> {
//         public int compare(int[] a, int[] b){
//             return a[0] - b[0];
//         }
//     }
// class SortByProfit implements Comparator<List> {
//     public int compare(int[] a, int[] b){
//         return b[1] - a[1];
//     }
// }
class Solution {
    
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqProfits = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (int i = 0; i < profits.length; i++) {
            pqCapital.add(new int[] {capital[i], profits[i]});
        }
        
        for (int i = 0; i < k; i++) {
            while (!pqCapital.isEmpty() && pqCapital.peek()[0] <= w) {
                pqProfits.add(pqCapital.poll());
            }
            
            if (pqProfits.isEmpty()) break;
            
            w += pqProfits.poll()[1];
        }
        
        return w;
    }
}