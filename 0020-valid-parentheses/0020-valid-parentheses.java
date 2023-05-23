class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(!stack.empty()){
                if(ch == ')'){
                    char out = stack.pop();
                    if (out != '(')
                        return false;
                }
                else if(ch == '}'){
                    char out = stack.pop();
                    if (out != '{')
                        return false;
                }
                else if(ch == ']'){
                    char out = stack.pop();
                    if (out != '[')
                        return false;
                }
            }
            else 
                return false;
        }
        return stack.empty() ? true: false;
    }
}