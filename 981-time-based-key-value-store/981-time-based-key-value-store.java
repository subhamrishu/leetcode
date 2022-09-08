class TimeMap {
    class TimeValue{
        String val;
        int timestamp;
        TimeValue(String val, int timestamp){
            this.val = val;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<TimeValue>> map;
    public TimeMap() {
       map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))
            return "";
        
        if (timestamp < map.get(key).get(0).timestamp)
            return "";
        
        List<TimeValue> temp = map.get(key);
        int low = 0, high = temp.size();
        // System.out.println("low = "+ low + " high= "+ high + " timestamp = " + timestamp);
        
        while (low < high){
            int mid = low + (high-low)/2;
            
            if (temp.get(mid).timestamp <= timestamp)
                low = mid+1;
            else
                high = mid;
        }
        if (high == 0)
            return "";
        return temp.get(high-1).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */