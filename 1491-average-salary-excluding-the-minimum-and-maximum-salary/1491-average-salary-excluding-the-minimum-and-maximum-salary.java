class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < salary.length; i++){
            sum += salary[i];
            min = min > salary[i] ? salary[i] : min;
            max = max < salary[i] ? salary[i] : max;
        }
        sum -= min;
        sum -= max;
        return sum*1.0/(salary.length-2);
    }
}