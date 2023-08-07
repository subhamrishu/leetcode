class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if (s1.length() < s2.length()){
            return gcdOfStrings(s2, s1);
        }
        if (s1.charAt(0) != s2.charAt(0)) return "";
        for (int i = s2.length(); i>0; i--){
            boolean flag = true;
            String x = s2.substring(0, i);
            int xlen = x.length();
            if (s1.length() % xlen != 0 || s2.length() % xlen != 0) continue;
            // int j = 0;
            // for (j = 0; j <= s1.length()-xlen; j+= xlen){
            //     // System.out.println(j+" " +s1.substring(j, j+x.length()) +" "+x);
            //     if (!x.equals(s1.substring(j, j+xlen))){
            //         flag = false;
            //         break;
            //     }
            // }
            if (s1.replace(x, "").isEmpty() && s2.replace(x, "").isEmpty()) return x;
            // System.out.println(j);
            // if (flag && j == s1.length())
            //     return x;
        }
        return "";
    }
}