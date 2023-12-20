class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, flag = 0;
        for (int i = 0; i < prices.length; i++){
            if (min1 > prices[i]){
                min2 = min1;
                min1 = prices[i];
                flag = 1;
            }
            if (min2 > prices[i] && flag == 0){
                min2 = prices[i];
            }
            flag = 0;
        }
        // System.out.println(min1 + " "+min2);
        return money - (min1+min2) >=0? money - (min1+min2) : money;
    }
}