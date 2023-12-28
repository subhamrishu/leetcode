class MyCalendar {
private TreeSet<int[]> calendar;

    public MyCalendar() {
        calendar = new TreeSet<>((a, b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        int[] newEvent = new int[]{start, end};
        int[] floor = calendar.floor(newEvent);
        int[] ceiling = calendar.ceiling(newEvent);

        if ((floor == null || floor[1] <= start) && (ceiling == null || end <= ceiling[0])) {
            calendar.add(newEvent);
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