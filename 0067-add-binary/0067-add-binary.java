class Solution {
//     int addDigits(char a, char b, StringBuilder ){
        
//     }
    public String addBinary(String a, String b) {
        if (a.length() < b.length())
            return addBinary(b, a);
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = a.length() - 1, j = b.length() - 1, sum = 0;
        while(i >= 0){
            if (j >= 0){
                sum = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carry;
                carry = (sum == 0 || sum == 1) ? 0 : 1;
                if (sum == 0 || sum == 2)
                    sb.insert(0, '0');
                else if(sum == 1 || sum == 3)
                    sb.insert(0, '1');
                i--; j--;
            }
            else {
                sum = (a.charAt(i)-'0')  + carry;
                carry = (sum == 0 || sum == 1) ? 0 : 1;
                if (sum == 0 || sum == 2)
                    sb.insert(0, '0');
                else if(sum == 1 || sum == 3)
                    sb.insert(0, '1');
                i--;
            }
        }
        if (carry == 1)
            sb.insert(0, '1');
        return sb.toString();
    }
}