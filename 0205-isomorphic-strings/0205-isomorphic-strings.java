class Solution {
    public boolean isIsomorphic(String s, String t) {
//         Map<Character, Character> mapS_T = new HashMap<>();
//         Map<Character, Character> mapT_S = new HashMap<>();
        
//         for (int i = 0; i < s.length(); i++){
//             char sc = s.charAt(i);
//             char st = t.charAt(i);
//             if (!mapS_T.containsKey(sc) && !mapT_S.containsKey(st)){
//                 mapS_T.put(sc, st);
//                 mapT_S.put(st, sc);
//             }
//             else if(!((mapS_T.containsKey(sc) && mapS_T.get(sc) == st) && (mapT_S.containsKey(st) && mapT_S.get(st) == sc)))
//                 return false;
//         }
//         return true;
        int[] mapS_T = new int[256];
        int[] mapT_S = new int[256];
    
        for(int i = 0 ; i < s.length(); i++){
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if (mapS_T[sc] == 0 && mapT_S[st] == 0){
                mapS_T[sc] = st;
                mapT_S[st] = sc;
            }
            else if(!(mapS_T[sc] == st && mapT_S[st] == sc))
                return false;
        }
        return true;
    }
}