class Solution {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int m = v1.length, n = v2.length;
        int i = 0, j = 0;
        
        while (i < m || j < n){
            
            int a = 0, b = 0;
            while(i < m && v1[i] != '.'){
                a += a * 10 + v1[i]-'0';
                i++;
            }
            i++;
            
            while(j < n && v2[j] != '.'){
                b += b * 10 + v2[j]-'0';
                j++;
            }
            j++;
            
            // System.out.println(a+" "+b);
            if (a < b) return -1;
            else if (a > b) return 1;
        }
        return 0;
    }
}