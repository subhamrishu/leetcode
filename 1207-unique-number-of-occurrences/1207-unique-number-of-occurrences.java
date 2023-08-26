class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int[] freq = new int[2003];
        for (int i = 0; i < n; i++){
            freq[arr[i]+1000]++; 
        }
        int[] count  = new int[2002];
        for (int i = 0; i <= 2002; i++){
            if (freq[i] > 0){
                count[freq[i]]++;
                if (count[freq[i]] > 1) return false;
            }
        }
        return true;
    }
}