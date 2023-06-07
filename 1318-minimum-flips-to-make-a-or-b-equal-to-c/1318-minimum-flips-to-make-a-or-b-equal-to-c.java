class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (c != 0 || a!=0 || b!=0){
            if ((c&1) == 1){
                if (((a&1)|(b&1))!=1){
                   count++; 
                }
            }
            else if ((c&1) == 0){
                if ((a&1) == 1)
                    count++;
                if ((b&1) == 1)
                    count++;
            }
            c = c >> 1;
            b = b >> 1;
            a = a >> 1;
        }
        // System.out.println("a="+a+" b="+b+" c="+c+" count="+count);
        // while (a!=0 || b!=0){
        //     if ((a&1) == 1)
        //             count++;
        //     if ((b&1) == 1)
        //         count++;
        //     a = a >> 1;
        //     b = b >> 1;
        // }
        // System.out.println("a="+a+" b="+b+" c="+c+" count="+count);
        return count;
    }
}