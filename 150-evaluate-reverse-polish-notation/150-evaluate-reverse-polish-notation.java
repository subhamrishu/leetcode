class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for (String token: tokens){
            if (token.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if (token.equals("-")){
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            }
            else if(token.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(token.equals("/")){
                int a = stack.pop(), b = stack.pop();
                stack.push((int)b/a);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}