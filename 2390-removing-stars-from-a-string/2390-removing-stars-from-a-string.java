class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        // StringBuilder sb = new StringBuilder();
        char[] str = new char[stack.size()];
        int k = stack.size()-1;
        while (!stack.isEmpty()){
            // sb.append(stack.pop());
            str[k--] = stack.pop();
        }
        return new String(str);
    }
}