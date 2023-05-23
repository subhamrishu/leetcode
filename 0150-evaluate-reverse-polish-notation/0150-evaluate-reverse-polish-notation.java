class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch: tokens){
            if (!"+-*/".contains(ch)) {
                stack.push(Integer.valueOf(ch));
                continue;
            }
            int val1 = stack.pop();
            int val2 = stack.pop();
            if (ch.equals("+")){
                stack.push(val2+val1);
            }
            else if(ch.equals("-")){
                stack.push(val2-val1);
            }
            else if(ch.equals("*")){
                stack.push(val2*val1);
            }
            else if(ch.equals("/")){
                stack.push(val2/val1);
            }
        }
        return stack.pop();
    }
}