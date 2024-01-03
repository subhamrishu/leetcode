class Solution {
    int numberOfSetBits(String s){
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < cs.length; i++){
            if (cs[i] == '1')
                count++;
        }
        return count;
    }
    public int numberOfBeams(String[] bank) {
        
        int prev = 0, curr = 0, count = 0;
        for (String b : bank){
            curr = numberOfSetBits(b);
            if (curr == 0)
                continue;
            
            count += prev * curr;
            prev = curr;
        }
        return count;
    }
}