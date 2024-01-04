class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                if (i*i != n)
                    factors.add(n/i);
                count++;
            }
            if (count == k)
                return i;
        }
        k -= count;
        if (factors.size() - k < 0)
            return -1;
        return factors.get(factors.size() - k);
        // k -
        // for (int i = factors.size() - 1; i >= 0; i--){
        //     factors
        // }
        // count++;
        // if (count == k)
        //     return n;
        // return -1;
    }
}