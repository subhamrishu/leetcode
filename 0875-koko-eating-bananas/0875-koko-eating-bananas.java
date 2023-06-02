class Solution {
    static boolean canEatAll(int[] piles, int K, int h){
        long count = 0;
        for (int pile : piles){
            count += pile/K;
            if (pile % K != 0){
                count++;
            }
        }
        return count <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for (int pile: piles){
            high = Math.max(high, pile);
        }
        // System.out.println(high);
        while (low <= high){
            int K = low + ((high - low) >> 1);
            if (canEatAll(piles, K, h)){
                high = K-1;
            }
            else 
                low = K + 1;
        }
        return low;
    }
}