class Solution {
    boolean checkForAllZero(int[] arr){
        for (int f: arr){
            if (f > 0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        if (s1.length() > s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }
        if (checkForAllZero(freq))
            return true;
        int j = 0;
        for (int i = s1.length(); i < s2.length(); i++){
            freq[s2.charAt(j)-'a']++;
            freq[s2.charAt(i)-'a']--;
            if (checkForAllZero(freq))
                return true;
            j++;
        }
        return false;
    }
}