class Solution {
    public int compress(char[] chars) {
        int j = 0, n = chars.length, sum = 0;
        for (int i = 0; i < n; i++){
            int curr = i;
            // int cnt = 0;
            while (i < n-1 && chars[i] == chars[i+1]){
                i++;
            }
            int cnt= i - curr+1;
            chars[j++] = chars[curr];
            sum++;
            if (cnt > 1){
                String s = Integer.toString(cnt);
                for (int k = 0; k < s.length(); k++){
                    chars[j++]= s.charAt(k);
                    sum++;
                }
                
            }
        }
        return sum;
    }
}