class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String ch: tokens){
            if (ch.equals("+")){
               int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2+val1);
            }
            else if(ch.equals("-")){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2-val1);
            }
            else if(ch.equals("*")){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2*val1);
            }
            else if(ch.equals("/")){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2/val1);
            }
            else{
                stack.push(Integer.valueOf(ch));
            }
        }
        return stack.pop();
    }
}