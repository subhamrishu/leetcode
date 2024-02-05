class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
        for (char ch ='a'; ch <= 'z'; ch++){
            
            int frontIdx = s.indexOf(ch);
            if (frontIdx != -1 && s.lastIndexOf(ch) == frontIdx)
                ans = Math.min(ans, frontIdx);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}