class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", "#");
        String[] words = paragraph.split("#");
        System.out.println(Arrays.toString(words));
        Map<String, Integer> map = new HashMap<>();
        
        for (String word: banned){
            map.put(word, map.getOrDefault(word, -1));
        }
        int max = 0;
        String maxWord = "";
        for (String word: words){
            if (!map.containsKey(word)){
                map.put(word, 0);
            }
            int count = map.get(word);
            if (count >= 0 && word.length() > 0){
                map.put(word, count+1);
                if (max < count+1){
                    max = count+1;
                    maxWord = word;
                }
            }
        }
        return maxWord;
    }
}