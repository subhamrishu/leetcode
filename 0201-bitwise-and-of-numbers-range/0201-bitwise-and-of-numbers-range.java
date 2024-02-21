class Solution {
//     public int rangeBitwiseAnd(int left, int right) {
//         if (left == 0 || right == 0)
//             return 0;
//         if (left == right)
//             return left;
//         long p = 0;
//         for (int i = 0; i <= 32; i++){
//             p = (long)Math.pow(2, i);
//             // if (p >= left && p <= right){
//             //     break;            
//             // }
//             if (p > (long)right){
//                 p = (long)Math.pow(2, i-1);
//                 break;
//             }
//         }
        
//         if (p != 0 && p <= right && p > left){
//             // if (p < right)
//             //     return 0;
//             // left = p;
//             return 0;
//         }
        
        
//         // left = left < (int)p ? (int)p : left;
        
//         // System.out.println("p = "+p+" left = "+left);
//         for (int i = left; i <= right && i>=0; i++){
//             left &= i;
//         }
//         return left;
//     }
        public int rangeBitwiseAnd(int left, int right) {
            int res = right;
            while(right > left) {
                res = right & (right-1);
                right = res;
            }
            return res;
        
    }
}