class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if (n == 0) return true;
        for (int i = 0; i < m; i++){
            if (flowerbed[i] == 0 && (i==0 || (i-1 > 0 && flowerbed[i-1] == 0)) && (i == m -1 || (i+1 < m && flowerbed[i+1] == 0))){
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) break;
        }
        return n == 0;
    }
}