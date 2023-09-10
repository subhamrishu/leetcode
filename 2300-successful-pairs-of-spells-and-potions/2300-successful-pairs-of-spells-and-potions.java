class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        // Arrays.sort(spells);
        
        int n = spells.length, m = potions.length;
        // int count = 0, prev = m - 1;
        int[] pairs= new int[n];
        for (int i = 0; i < n; i++){
            int lo = 0, hi = m;
            int maxPotion = potions[m - 1];
            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);
            if (minPotion > maxPotion) {
                pairs[i] = 0;
                continue;
            }
            while (lo < hi){
                int mid = (lo + hi)/2;
                // long prod = spells[i] * potions[mid];
                if (potions[mid] < (int)minPotion)
                    lo = mid + 1;
                else 
                    hi = mid;
            }
            // if (lo > hi && lo == m)
            //     pairs[i] = 0;
            // else
                pairs[i] = m - lo;
            // prev = lo;
        }
        return pairs;
    }
}