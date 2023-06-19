class Solution {
    public int largestAltitude(int[] gain) {
        int highestAlt = 0, curr = 0;
        for (int g: gain){
            curr += g;
            highestAlt = Math.max(highestAlt, curr);
        }
        return highestAlt;
    }
}