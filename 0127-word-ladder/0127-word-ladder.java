class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
       
        int level = 1;
        q.add(beginWord);
        while (!q.isEmpty()){
            for (int k = q.size(); k > 0; k--){
                String currWord = q.poll();
                if (currWord.equals(endWord)){
                    return level;
                }
                for (int i = 0; i < currWord.length(); i++){
                    for (char j = 'a'; j <= 'z'; j++){
                        char[] sc = currWord.toCharArray();
                        sc[i] = j;
                        String cs = new String(sc);
                        if (dict.contains(cs) && !visited.contains(cs)){
                            q.add(cs);
                            visited.add(cs);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}