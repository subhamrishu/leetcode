class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> record = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!record.containsKey(c)) {
                record.put(c, new ArrayList<>());
            }
            record.get(c).add(i);
        }
        
        int res = 0;
        for (String cur : words) {
            int index = -1;
            boolean isSubsequence = true;
            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                if (!record.containsKey(c)) {
                    isSubsequence = false;
                    break;
                }
                List<Integer> list = record.get(c);
                int pos = Collections.binarySearch(list, index + 1);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                if (pos == list.size()) {
                    isSubsequence = false;
                    break;
                }
                index = list.get(pos);
            }
            if (isSubsequence) {
                res += 1;
            }
        }
        return res;
    }
}