class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi){
            int mid = (lo + hi)/2;
            if (letters[mid] <= target)
                lo = mid + 1;
            else 
                hi = mid;
        }
        return hi < letters.length ? letters[hi] : letters[0];
    }
}