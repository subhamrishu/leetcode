class Solution {
    public int maxScore(String s) {
        int zero=0, one=0;
        char cs[] = s.toCharArray();
        
        for (char ch: cs){
            if (ch == '0')
                zero++;
            else
                one++;
        }
        if (zero == cs.length || one == cs.length){
            return cs.length-1;
        }
        int l = 0, r = one, m = 0; 
        if (cs[0] == '0')
                l++;
            else
                r = r-1;
        m = Math.max(m, l+r);
        for(int i = 1; i < cs.length-1; i++){
            if (cs[i] == '0')
                l++;
            else
                r = r-1;
            m = Math.max(m, l+r);
        }
        return m;
    }
}