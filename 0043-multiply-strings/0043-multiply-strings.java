class Solution {
    String sumOfString(String a, String b){
        if (a.length() < b.length())
            return sumOfString(b, a);
        int carry = 0, a_len = a.length(), b_len= b.length();
        StringBuilder sb = new StringBuilder();
        while (a_len != 0){
            int a_digit = a.charAt(a_len-1)-48;
            int sum = 0;
            if (b_len != 0){
                int b_digit = b.charAt(b_len-1)-48;
                sum = b_digit;
                b_len--;
            }
            sum += a_digit+carry;
            carry = sum/10;
            sb.append(sum%10);
            a_len--;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length())
            return multiply(num2, num1);
        int n = num2.length(), pos = 0;
        String sum=new String();
        while (n != 0){
            int b = num2.charAt(n-1)-48;
            int m = num1.length(), carry=0;
            StringBuilder sb = new StringBuilder();
            
            while (m != 0){
                int a = num1.charAt(m-1)-48;
                // System.out.println(a+" "+b);
                int prod = (a * b) + carry;
                carry = prod / 10;
                sb.append(prod%10);
                m--;
            }
            if (carry != 0)
                sb.append(carry);
            sb = sb.reverse();
            for (int i = 0; i < pos ; i++){
                sb.append('0');
            }
            pos++;
            // System.out.println(sb.toString());
            n--;
            sum = sumOfString(sum, sb.toString());
            // System.out.println(sum);
        }
        // for(int i = 0; i < sum.length(); i++){
        //     if (sum.charAt(i) != '0')
        //         return sum;
        // }
        return sum.charAt(0) == '0' ? "0" : sum;
    }
}