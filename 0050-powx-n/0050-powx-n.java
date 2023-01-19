class Solution {
    public double myPow(double x, int n) {
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        double sol = 1;
        while (n != 0){
            if ((n & 1) != 0){
                sol *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return sol;
    }
}