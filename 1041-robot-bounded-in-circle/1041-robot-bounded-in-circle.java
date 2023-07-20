class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] pos = new int[3];
        //pos[2] = direction, pos[2]==0 -> north, pos[2]==1 -> east, pos[2]==2 -> south, pos[2]==3 -> west 
        for (char ch: instructions.toCharArray()){
            if (ch == 'G'){
                if (pos[2] == 0){
                    pos[1]+=1;
                }else if (pos[2] == 1){
                    pos[0] += 1;
                }else if (pos[2] == 2){
                    pos[1] -= 1;
                }else if (pos[2] == 3){
                    pos[0] -= 1;
                }
                
            }else if(ch == 'L'){
                pos[2] = (((pos[2] - 1)%4) + 4)%4;
            }else if(ch == 'R'){
                pos[2] = (((pos[2] + 1)%4) + 4)%4;
            }
            // System.out.println(Arrays.toString(pos));
        }
        // System.out.println(Arrays.toString(pos));
        if ((pos[0] == 0 && pos[1] == 0) || pos[2] != 0)
            return true;
        return false;
    }
}