class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1 != n2) return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for (int i = 0; i < n1; i++){
            f1[word1.charAt(i)-'a']++;
            f2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (f1[i] > 0 && f2[i] == 0 || f2[i] > 0 && f1[i] == 0) return false;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 26; i++){
            int c1 = f1[i], c2 = f2[i];
            countMap.put(c1, countMap.getOrDefault(c1, 0)+1);
            countMap.put(c2, countMap.getOrDefault(c2, 0)-1);
        }
        for (int key: countMap.keySet()){
            if (countMap.get(key) > 0) return false;
        }
        return true;
    }
}