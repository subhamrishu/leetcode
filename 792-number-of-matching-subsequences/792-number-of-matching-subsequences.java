
class Solution {
    class Node{
        String word;
        int index;
        Node(){
            
        }
        Node(String w, int i){
            word =w;
            index = i;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        /* Brute Force Solution: TLE
        HashMap<Character, Integer> map = new HashMap();
        char[] c = s.toCharArray();
        // for (int i =0; i < c.length; i++){
        //     map.put(c, i);
        // }
        int count = 0;
        for (String word: words){
            char w[] = word.toCharArray();
            if (w.length > c.length)
                continue;
            int k, i, j = 0, c_len = c.length, local_count = 0;
            for (i = 0; i < w.length && j < c_len; i++){
                for (k = j; k < c_len; k++){
                    if (w[i] == c[k]){
                        local_count += 1;
                        break;
                    }
                }
                j = k+1;  
            }
            if (local_count == w.length)
                count+=1;
        }
        return count;
        */
        /* Usng hashmap of lists : use binary search for optimisation
        Map<Character, ArrayList<Integer>> map = new HashMap();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            map.putIfAbsent(c[i], new ArrayList());
            map.get(c[i]).add(i);
        }
        int count = 0; 
        for (String word: words){
            char w[] = word.toCharArray();
            if (w.length > c.length)
                continue;
            int localCount = 0, lastIndex = -1;;
            for (char ch: word.toCharArray()){
                if (!map.containsKey(ch) || map.get(ch).size()==0)
                    break;
                // int temp = map.get(ch).removeFirst();
                int temp=-1;
                for (int ind: map.get(ch)){
                    if (ind > lastIndex){
                        temp = ind;
                        break;
                    }
                }
                if (temp == -1)
                    break;
                lastIndex = temp;
                localCount++;
            }
            if (localCount == w.length)
                count ++;
        }
        return count;
        */
        // ArrayList<Node>[] mapping = new ArrayList[26];
        HashMap<Character, Queue<Node>> map = new HashMap();
        for (char ch = 'a'; ch <= 'z'; ch++){
            map.put(ch, new LinkedList());
        }
        for (String word: words){
            map.get(word.charAt(0)).add(new Node(word, 0));
        }
        int count = 0;
        for(char ch: s.toCharArray()){
            Queue<Node> currList = map.get(ch);
            int size = currList.size();
            for (int i =0; i< size; i++){
                Node top = currList.poll();
                top.index++;
                if(top.index == top.word.length())
                    count++;
                else{
                    map.get(top.word.charAt(top.index)).add(top);
                }
            }
        }
        return count;
    }
}