class TimeMap {
    class Pair{
        String val;
        int time;
        Pair(String val, int time){
            this.val = val;
            this.time = time;
        }
    }
    Map<String, ArrayList> map;
    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Pair>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair> list;
        if (map.containsKey(key))
            list = map.get(key);
        else
            return "";
        int lo = 0, hi = list.size()-1;
        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            if (list.get(mid).time == timestamp)
                return list.get(mid).val;
            else if(list.get(mid).time < timestamp)
                lo = mid + 1;
            else
                hi = mid;
        }
        if (list.get(lo).time <= timestamp)
            return list.get(lo).val;
        if (lo-1 < 0)
            return "";
        return list.get(lo-1).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */