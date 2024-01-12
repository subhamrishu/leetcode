class Solution {
    public boolean halvesAreAlike(String s) {
        int[]isVowel = new int[123];
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for (char v : vowels){
            isVowel[v] = 1;
        }
        int n  = s.length();
        char[] cs = s.toCharArray();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n/2; i++){
            if (isVowel[cs[i]] == 1) c1++;
            if (isVowel[cs[n-i-1]] == 1) c2++;
        }
        return c1 == c2;
        
    }
}