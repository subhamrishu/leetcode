class Solution {
    int numOfDigits(int n){
        int k  = 0;
        while (n > 0){
            n /= 10;
            k++;
        }
        return k;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> sol = new ArrayList<>();
        int size = 0;
        for (int i = numOfDigits(low); i <= numOfDigits(high); i++){
            for (int j = 1; j <= 9; j++){
                int k = j, num = 0;
                for (size = 0; size < i; size++){
                    if (num > high || k > 9)
                        break;
                    num = num *10 + k;
                    k++;
                }
                if (num>=low && num <= high && size == i)
                    sol.add(num);
            }
        }
        return sol;
    }
}