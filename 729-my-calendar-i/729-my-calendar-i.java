class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        
        Integer event_start = calendar.floorKey(start);
        Integer event_end = calendar.ceilingKey(start);
        
        if ((event_start == null || calendar.get(event_start) <= start) && (event_end == null || end <= event_end)){
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */