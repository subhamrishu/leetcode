class Solution {
    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }
    
    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        
        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }
        
        String hashKey = String.valueOf(chars);
        return hashKey;
    }
    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, Map<String, List<String>>> map = new HashMap<>();
        
        for (String s: strings){
            int len = s.length();
            if (!map.containsKey(len))
                map.put(len, new HashMap<>());
            // List<Integer> diff = new ArrayList<>();
            // for (int j = 0; j < s.length()-1; j++){
            //     diff.add(26-Math.abs(s.charAt(j) - s.charAt(j+1)));
            // }
            // StringBuilder out = new StringBuilder();
            // for (Integer d : diff)
            // {
            //   out.append(d.toString());
            //   out.append(",");
            // }
            String hash = getHash(s);
            if (!map.get(len).containsKey(hash))
                map.get(len).put(hash, new ArrayList<>());
            map.get(len).get(hash).add(s);
        }
        List<List<String>> sol = new ArrayList<>();
        for (var entry: map.entrySet()){
            Map<String, List<String>> map2 = entry.getValue();
            for (var entry2: map2.entrySet()){
                sol.add(entry2.getValue());
            }
        }
        return sol;
    }
}