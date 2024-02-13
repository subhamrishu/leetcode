public class Codec {
    int lenOfInt(int n){
        int count = 0;
        while (n > 0){
            n /= 10;
            count++;
        }
        return count;
    }
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        char sep = '*';
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            int len = str.length();
            int count = lenOfInt(len);
            sb.append(count);
            sb.append(len);
            sb.append(str);
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> l = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        int i = 0; 
        while (i < s.length()){
            // sb = new StringBuilder();
            int l_n = s.charAt(i)-'0';
            i++;
            String s_len = s.substring(i, i+l_n);
            if (s_len.equals("")){
                i = i+l_n+1;
                l.add("");
                continue;
            }
            int len = Integer.parseInt(s_len);
            int k = i+l_n+len;
            l.add(s.substring(i+l_n, k));
            i = k;
        }
        return l;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));