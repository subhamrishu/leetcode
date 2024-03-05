class Solution {
    public int minimumLength(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0, j = n-1;
        
        while (i < j && cs[i] == cs[j]){
            char currChar = cs[i];
            while (i < j && cs[i] == currChar)
                i++;
            if (i == j) return 0;
            while (i < j && currChar == cs[j])
                j--;
            // System.out.println("i="+i+" j="+j);
            if (i == j) return j-i+1;
        }
        // System.out.println("i="+i+" j="+j);
        return j-i+1;
    }
}