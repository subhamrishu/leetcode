class Solution {
    public String reverseVowels(String s) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));
        char[] ss = s.toCharArray();
        int n = s.length();
        int i = 0, j = n-1;
        while (i < j){
            while (i<n && i<j && !set.contains(ss[i])) {
                i++;
            }
            while (j >= 0 && i<j && !set.contains(ss[j])){ 
                j--;
            }
            // System.out.println(i+" "+j);
            Character temp = ss[i];
            ss[i++] = ss[j];
            ss[j--] = temp;
            // i++; j--;
        }
        return new String(ss);
    }
}