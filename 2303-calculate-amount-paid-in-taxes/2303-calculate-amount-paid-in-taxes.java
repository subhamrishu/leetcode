class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double tax  = 0;
        int upper = 0;
        for (int i = 0; i < brackets.length && income != 0; i++){
            if (i != 0){
                upper = Math.min(brackets[i][0] - brackets[i-1][0], income);
            }else{
                upper = Math.min(brackets[i][0], income);
            }
            tax += upper * (brackets[i][1]*1.0/100);
            income -= upper;
            
        }
        return tax;
    }
}