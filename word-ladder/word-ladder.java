class Solution {
    class TreeNode{
        String word;
        int level;
        TreeNode(String w, int l){
            this.word = w;
            this.level = l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> map = new HashMap<>();
        
        for(String word: wordList){
            for (int i = 0; i < word.length(); i++){

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                List<String> transformations = map.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                map.put(newWord, transformations);
            }

        }
        // for (String key: map.keySet()){
        //     System.out.println(key + " "+map.get(key));
        // }
        if (!set.contains(endWord)) return 0;

        if (set.contains(beginWord))
            set.remove(beginWord);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(beginWord, 1));

        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            
            // if (curr.level > wordList.size()) return 0;
            String currWord = curr.word;
            // System.out.println("Popped word: "+ currWord);
            if (currWord.equals(endWord)){
                return curr.level;
                // min = Math.min(min, curr.level);
            }
            
            for (int i = 0; i < currWord.length(); i++){
                String newWord = currWord.substring(0, i) + '*' + currWord.substring(i+1);
                // System.out.println("new word: "+ newWord);
                for(String adjacentWord: map.getOrDefault(newWord, new ArrayList<>())){
                    if (adjacentWord.equals(endWord)) return curr.level + 1;

                    if (set.contains(adjacentWord)){
                        set.remove(adjacentWord);
                        // System.out.println(adjacentWord+" "+(curr.level+1));
                        q.offer(new TreeNode(adjacentWord, curr.level+1));
                    }
                }
                // for (char ch = 'a'; ch <= 'z'; ch++){
                //     String temp = currWord.substring(0, i) + ch + currWord.substring(i+1);
                    
                //     if (set.contains(temp)){
                //         // System.out.println(temp+" "+(curr.level+1));
                //         q.offer(new TreeNode(temp, curr.level+1));
                //         set.remove(temp);
                //     }
                // }
            }
        }
        return 0;
    }
}