class Solution {
    public int countOdds(int low, int high) {
        int num = (high - low)/2 + 1;
        if (low%2 == 0 && high%2 == 0){
            num--;
        }
        return num;
    }
}