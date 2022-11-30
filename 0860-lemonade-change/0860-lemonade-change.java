class Solution {
    public boolean lemonadeChange(int[] bills) {
        int FIVE = 0, TEN = 1, TWENTY = 2;
        int[] notes = new int[3];
        for (int bill: bills){
            if (bill == 5){
                notes[FIVE]++;
            }
            else if (bill == 10){
                notes[TEN]++;
                if(notes[FIVE] > 0)
                    notes[FIVE]--;
                else
                    return false;
            }
            else{
                notes[TWENTY]++;
                if (notes[TEN] > 0 && notes[FIVE] > 0){
                    notes[TEN]--; notes[FIVE]--;
                }
                else if(notes[FIVE] >= 3){
                    notes[FIVE]-=3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}