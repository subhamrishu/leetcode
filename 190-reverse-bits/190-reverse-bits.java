public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int op = 0;
        for(int i = 0; i<32; i++){
            op = (op << 1) | (n&1);
            n = n >> 1;
        }
        return op;
    }
}