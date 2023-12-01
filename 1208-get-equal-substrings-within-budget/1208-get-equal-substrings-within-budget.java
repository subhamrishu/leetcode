class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, ans = 0, currCost = 0, N= s.length();
        char[] sc = s.toCharArray();
        char []tc = t.toCharArray();
        for (int right = 0; right < sc.length; right++){
            currCost += Math.abs(tc[right] - sc[right]);
            // System.out.println("CurrCost = "+currCost);
            while (currCost > maxCost && left <=right){
                currCost -= Math.abs(tc[left] - sc[left]);
                left++;
            }
            ans = Math.max(ans, right-left+1);
            // System.out.println("CurrCost = "+currCost+" ans = "+ans);
        }
        return ans;
    }
}