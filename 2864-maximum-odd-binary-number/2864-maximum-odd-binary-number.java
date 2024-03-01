class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0, n = s.length();
        for (char ch: s.toCharArray()){
            if (ch == '1')
                count++;
        }
        // sb.append('1');
        // count--;
        for (int i = 0; i < n-1; i++, count--){
            if (count > 1)
                sb.append('1');
            else
                sb.append('0');
        }
        // for (int i = 0; i < count; i++){
        //     sb.append('1');
        // }
        return sb.append('1').toString();
    }
}