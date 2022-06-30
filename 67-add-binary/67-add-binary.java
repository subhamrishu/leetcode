class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sumInBinary = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, carry = 0;
        while (i>=0 && j>=0){
            if (a.charAt(i) == '1' && b.charAt(j) == '1'){
                if (carry == 1)
                    sumInBinary.insert(0,'1');
                else
                    sumInBinary.insert(0,'0');
                carry = 1;
            }
            else if(a.charAt(i) == '0' && b.charAt(j) == '0'){
                if (carry == 1)
                    sumInBinary.insert(0,'1');
                else
                    sumInBinary.insert(0,'0');
                carry = 0;
            }
            else {
                if (carry == 1)
                    sumInBinary.insert(0,'0');
                else
                    sumInBinary.insert(0,'1');
                
            }
            i--;
            j--;
            // System.out.println(sumInBinary.toString());
        }
        while (i >= 0){
            if (a.charAt(i) == '1'){
                if (carry == 1)
                    sumInBinary.insert(0,'0');
                else
                    sumInBinary.insert(0,'1');
            }
            else{
                if (carry == 1)
                    sumInBinary.insert(0,'1');
                
                else
                    sumInBinary.insert(0,'0');
                carry = 0;
            }
            i--;
            // System.out.println(sumInBinary.toString());
        }
        while (j >= 0){
            if (b.charAt(j) == '1'){
                if (carry == 1)
                    sumInBinary.insert(0,'0');
                else
                    sumInBinary.insert(0,'1');
            }
            else{
                if (carry == 1)
                    sumInBinary.insert(0,'1');
                else
                    sumInBinary.insert(0,'0');
                carry = 0;
            }
            j--;
            // System.out.println(sumInBinary.toString());
        }
        if (carry == 1)
            sumInBinary.insert(0,'1');
        return sumInBinary.toString();
    }
}