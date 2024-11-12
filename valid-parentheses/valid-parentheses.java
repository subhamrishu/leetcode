class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch: s.toCharArray()){
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if (stack.size() == 0) return false;
                char top = stack.pop();
                
                if (ch == ')' && top != '('){
                    return false;
                }else if (ch == '}' && top != '{'){
                    return false;
                }else if (ch == ']' && top != '['){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}