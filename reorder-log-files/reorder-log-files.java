class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        String[] sol = new String[n];

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String s: logs){
            if (s.charAt(s.length()-1) < 65){
                digits.add(s);
            }else{
                letters.add(s);
            }
        }
        Collections.sort(letters, new Comparator<String>() {
            public String[] getContentAndId(String s){
                String[] arr= new String[2];
                int i = 0;
                while (i < s.length() && s.charAt(i++) != ' ');
                arr[0] = s.substring(i);
                arr[1] = s.substring(0, i);
                return arr;
            }
            public int compare(String s1, String s2){
                String[] s1_l = getContentAndId(s1);
                String[] s2_l = getContentAndId(s2);

                // String s1_id = s1_l[0];
                // String s2_id = s2_l[0];

                // StringBuilder s1_extractedWords = new StringBuilder();
                // for (int i = 1; i < s1_l.length; i++) {
                //     s1_extractedWords.append(s1_l[i]);
                //     if (i < s1_l.length - 1) {
                //         s1_extractedWords.append(" ");
                //     }
                // }

                // String s1_result = s1_extractedWords.toString();

                // StringBuilder s2_extractedWords = new StringBuilder();
                // for (int i = 1; i < s2_l.length; i++) {
                //     s2_extractedWords.append(s2_l[i]);
                //     if (i < s2_l.length - 1) {
                //         s2_extractedWords.append(" ");
                //     }
                // }

                // String s2_result = s2_extractedWords.toString();
                int compareRes = s1_l[0].compareTo(s2_l[0]);
                if (compareRes == 0)
                    return s1_l[1].compareTo(s2_l[1]);
                else
                    return compareRes;

            }
        });
        int k = 0;
        for (String s: letters){
            sol[k++] = s;
        }
        for (String s: digits){
            sol[k++] = s;
        }
        return sol;
    }
}