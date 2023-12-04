class Solution {
    public String largestGoodInteger(String num) {
        char[] cn = num.toCharArray();
        int begin = -1, max = -1;
        
        for (int i = 0; i < cn.length-2; i++){
            if (cn[i] == cn[i+1] && cn[i+1] == cn[i+2] && max < cn[i]){
                begin = i;
                max = cn[i];
            }
        }
        return begin == -1 ? "" : num.substring(begin, begin + 3);
    }
}