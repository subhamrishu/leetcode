class Solution {
    public int[] plusOne(int[] digits) {
        int carry =1, n = digits.length;
    
        for (int i = n-1; i >=0 && carry!=0; i--){
            int sum = digits[i]+carry;
            carry = sum/10;
            digits[i] = sum%10;
        }
        if (carry==0)
            return digits;
        int[] sol = new int[n+1];
        int i=0;
        for (i = 1; i < n; i++){
            sol[i] = digits[i];
        }
        sol[0] = carry;
        return sol;
    }
}