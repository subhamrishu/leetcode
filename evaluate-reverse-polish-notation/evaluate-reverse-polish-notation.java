class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token: tokens){
            if (token.charAt(0) == '+'){
                int a = stack.pop(), b = stack.pop();
                stack.push(b+a);
            }else if(token.charAt(0) == '-' && token.length() == 1){
                int a = stack.pop(), b = stack.pop();
                stack.push(b-a);
            }else if(token.charAt(0) == '*'){
                int a = stack.pop(), b = stack.pop();
                stack.push(b*a);
            }else if(token.charAt(0) == '/'){
                int a = stack.pop(), b = stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.valueOf(token));
            }
            // System.out.println(stack.peek());
        }
        return stack.peek();
    }
}