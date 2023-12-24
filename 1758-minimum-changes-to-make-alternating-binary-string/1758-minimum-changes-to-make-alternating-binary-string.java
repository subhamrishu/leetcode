class Solution {
    public int minOperations(String s) {
        char[] cs = s.toCharArray();
        // int nextBit = cs[0] == '0' ? 1 : 0;
        int count1 = 0, count2 = 0;
//         for (int i = 1; i < cs.length; i++){
//             if (cs[i]-'0' != nextBit){
                
//             }
//         }
        for (int i = 0; i < cs.length; i+=2){
            if (cs[i] != '0'){
                count1++;
            }
            if (cs[i] != '1'){
                count2++;
            }
        }
        for (int i = 1; i < cs.length; i+=2){
            if (cs[i] != '1'){
                count1++;
            }
            if (cs[i] != '0'){
                count2++;
            }
        }
 
        // for (int i = 0; i < cs.length; i+=2){
        //     if (cs[i] != '1'){
        //         count2++;
        //     }
        // }
        // for (int i = 1; i < cs.length; i+=2){
        //     if (cs[i] != '0'){
        //         count2++;
        //     }
        // }
            return count1 < count2 ? count1 : count2;
    }
}