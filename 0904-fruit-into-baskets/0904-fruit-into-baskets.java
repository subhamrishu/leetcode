class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1)
            return 1;
        int fruit1 = -1, fruit2 = -1, curr = 0, fruit2Count = 0, max = 0;
        
        for (int fruit3: fruits){
            if (fruit3 == fruit1 || fruit3 == fruit2){
                curr++;
            }
            else{
                curr = fruit2Count + 1;
            }
            if (fruit3 == fruit2){
                fruit2Count++;
            }else{
                fruit2Count = 1;
            }
            if (fruit3 != fruit2){
                fruit1 = fruit2;
                fruit2 = fruit3;
            }
            max = (max < curr) ? curr : max;
        }
        return max;
    }
}