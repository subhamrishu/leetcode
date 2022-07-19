class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList();
        int n = 0;
        l.add(Arrays.asList(1));
        for (int i = 1; i<numRows; i++){
            List<Integer> temp = new ArrayList();
            temp.add(1);
            for (int j = 0; j<i-1; j++){
                temp.add(l.get(i-1).get(j)+l.get(i-1).get(j+1));
            }
            temp.add(1);
            l.add(temp);
        }
        return l;
    }
}