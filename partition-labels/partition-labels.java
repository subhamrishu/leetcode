class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> sol = new ArrayList<>();
        // Map<Character, int[]> map = new HashMap<>();
        int[] lastInd = new int[26];
        char[] arr=s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            lastInd[arr[i]-'a'] = i;
            // if (!map.containsKey(arr[i])){
            //     map.put(arr[i], new int[2]);
            //     map.get(arr[i])[0] = i;
            //     // map.get(s.charAt(i))[1] = i;
            // }
            // map.get(arr[i])[1] = i;
        }
        int j, max;
        for (int i = 0; i < s.length(); i++){
            j = i;
            max = lastInd[arr[i]-'a'];//map.get(arr[i])[1];
            while (i < max){
                max = Math.max(max, lastInd[arr[i]-'a']);
                i++;
            }
            sol.add(max-j+1);
        }
        return sol;
    }
}