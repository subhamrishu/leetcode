class Solution {
    boolean isNumber(String token){
        char c = token.charAt(0);
        boolean res = c >= 48 && c <= 57;
        return (c >= 48 && c <= 57)? true : (token.length() > 1 ? true: false);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        
        for (String token: tokens){
            if (isNumber(token))
                stack.push(Integer.parseInt(token));
            else{
                int a = stack.pop(), b = stack.pop();
                if (token.equals("+"))
                    stack.push(b+a);
                else if(token.equals("-"))
                    stack.push(b-a);
                else if(token.equals("*"))
                    stack.push(b*a);
                else
                    stack.push((int)b/a);
            }
            // if (token.equals("+")){
            //     stack.push(stack.pop() + stack.pop());
            // }
            // else if (token.equals("-")){
            //     int a = stack.pop(), b = stack.pop();
            //     stack.push(b - a);
            // }
            // else if(token.equals("*")){
            //     stack.push(stack.pop() * stack.pop());
            // }
            // else if(token.equals("/")){
            //     int a = stack.pop(), b = stack.pop();
            //     stack.push((int)b/a);
            // }
            // else{
            //     stack.push(Integer.parseInt(token));
            // }
        }
        return stack.pop();
    }
}