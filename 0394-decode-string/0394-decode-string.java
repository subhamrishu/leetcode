class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sol = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ']'){
                stack.push(s.charAt(i)+"");
            }else{
                StringBuilder temp = new StringBuilder();
                while (stack.peek().charAt(0) != '['){
                    temp.append(stack.pop());
                }
                stack.pop();//pop the [ character
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    num.append(stack.pop().charAt(0));
                }
                int k = Integer.parseInt(num.reverse().toString());
                // temp.reverse();
                String temp2 = "";
                for (int j = 0; j < k; j++){
                    temp2 += temp.toString();
                }
                stack.push(temp2);
            }
            
            
        }
        while (!stack.isEmpty()){
                sol.append(stack.pop());
        }
        return sol.reverse().toString();
    }
}