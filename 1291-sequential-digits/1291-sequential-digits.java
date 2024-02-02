class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int nLow = String.valueOf(low).length();
        int nHigh = String.valueOf(high).length();
        String s = "123456789";
        List<Integer> sol = new ArrayList<>();
        
        for (int len = nLow; len <= nHigh; len++){
            for (int right = 0; right < 10 - len; right++){
                int num = Integer.parseInt(s.substring(right, right+len));
                if (num >= low && num <= high)
                    sol.add(num);
            }
            
        }
        return sol;
    }
}