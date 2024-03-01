class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0, n = s.length();
        for (char ch: s.toCharArray()){
            if (ch == '1')
                count++;
        }
        sb.append('1');
        count--;
        for (int i = 0; i < n-count-1; i++){
            sb.append('0');
        }
        for (int i = 0; i < count; i++){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}