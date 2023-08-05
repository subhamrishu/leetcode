class Solution {
    public int minimumSeconds(List<Integer> nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int n = nums.size();
        // int[] m = new int[2];
        // m[0] = nums.get(0);
        // m[1] = 1;
        // for (int i = 0; i < n; i++){
        //     int count = map.getOrDefault(nums.get(i), 0);
        //     map.put(nums.get(i), count + 1);
        //     if (count + 1 > m[1]){
        //         m[0] = nums.get(i);
        //         m[1] = count + 1;
        //     }
        // }
        // int t = 0;
        // // int[] temp = new int[n];
        // System.out.println(m[0]);
        // boolean change = true;
        // while (change){
        //     change = false;
        //     int[] temp = new int[n];
        //     for (int i = 0; i < n; i++){
        //         int curr = nums.get(i), left = nums.get((i-1+n)%n), right = nums.get((i+1)%n);
        //         // System.out.print(curr+" "+left+" "+right+"---"+Arrays.toString(temp));
        //         if (curr != m[0] && (left == m[0] || right== m[0]) ){
        //             temp[i] = m[0];
        //             change = true;
        //         }else{
        //             temp[i]= curr;
        //         }
        //         System.out.print(curr+" "+left+" "+right+"---"+Arrays.toString(temp));
        //     }
        //     if (change == false) break;
        //     nums = new ArrayList();
        //     for (int i = 0; i< n; i++){
        //         nums.add(temp[i]);
        //     }
        //     t++;
        //     System.out.println();
        // }
        // return t;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n; i++){
            if(!map.containsKey(nums.get(i))){
                map.put(nums.get(i), new ArrayList<Integer>());
            }
            ArrayList<Integer> l = map.get(nums.get(i));
            l.add(i);
        }
        // System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int key: map.keySet()){
            ArrayList<Integer> l = map.get(key);
            l.add(l.get(0)+n);
            int longest = 0;
            for (int i = 0; i < l.size()-1; i++){
                int a = l.get(i), b = l.get(i+1);
                longest = Math.max(longest, (b-a)/2);
                // sum += Math.floor(((b-a-1+n)%n)/2);
                // sum += ((l.get((i+1)%l.size()) - (l.get(i)-1+n)%n))/2;
                // System.out.println(l.get((i+1)%l.size()) +" "+ (l.get(i)-1+n)%n);
            }
            // System.out.println(key+" "+sum);
            min = Math.min(longest, min);
        }
        return min;
        
    }
}