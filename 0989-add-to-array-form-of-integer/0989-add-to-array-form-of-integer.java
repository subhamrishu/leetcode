class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> l = new ArrayList<>();
        int carry = 0, sum = 0;
        for (int i = num.length-1; i >=0; i--){
            sum = num[i] + k%10 + carry;
            carry = sum/10;
            k = k/10;
            l.add(0, sum%10);
        }
        k = k + carry;
        while (k > 0){
            l.add(0, k%10);
            k/=10;
        }
        // if (carry > 0)
        //     l.add(0,carry);
        return l;
    }
}