class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1t = version1.split("\\.");
        String[] v2t = version2.split("\\.");
        // System.out.println(Arrays.toString(v1t)+" "+Arrays.toString(v2t));
        int n = Math.min(v1t.length, v2t.length);
        
        for (int i = 0; i < n; i++){
            int d1 = Integer.parseInt(v1t[i]);
            int d2 = Integer.parseInt(v2t[i]);
            // System.out.println(d1+" "+d2);
            if (d1 == d2) continue;
            
            if (d1 < d2) return -1;
            
            return 1;
        }
        if (v1t.length == v2t.length) return 0;
        
        else if(v1t.length > v2t.length) {
            while (n < v1t.length && Integer.parseInt(v1t[n]) == 0){
                n++;
            }
            if (n == v1t.length) return 0;
            return 1;
        }
        else{
            while (n < v2t.length && Integer.parseInt(v2t[n]) == 0){
                n++;
            }
            if (n == v2t.length) return 0;
            return -1;
        }
        // return -1;
    }
}