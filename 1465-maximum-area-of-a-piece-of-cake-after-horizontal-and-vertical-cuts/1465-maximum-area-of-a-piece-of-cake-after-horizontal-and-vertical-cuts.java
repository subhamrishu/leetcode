class Solution {
    int MODULO = 1000000007;
    int modMultiply(int a, int b){
        int res = 0;
        while (b > 0){
            if (b%2 == 1)
                res = (res+a)%MODULO;
            a = (a*2)%MODULO;
            b = b/2;
        }
        return res;
    }
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int lenHcuts = horizontalCuts.length-1, lenVcuts = verticalCuts.length-1;
        
        int max_height = Math.max(horizontalCuts[0],h - horizontalCuts[lenHcuts]),
        max_width = Math.max(verticalCuts[0],w - verticalCuts[lenVcuts]);
        // System.out.println(max_height+ " "+ max_width);
        for (int i =1; i<=lenHcuts; i++){
            max_height = Math.max(horizontalCuts[i] - horizontalCuts[i-1], max_height);
        }
        for (int i =1; i<=lenVcuts; i++){
            max_width = Math.max(verticalCuts[i] - verticalCuts[i-1], max_width);
        }
        max_height = max_height % MODULO;
        max_width = max_width % MODULO;
        long res = (long)max_height*max_width%MODULO;
        return (int)res;
        // System.out.println(max_height+ " "+ max_width+"\n");
        // return modMultiply(max_height, max_width);
    }
}