class Solution {
    final int YEAR = 0;
    final int MONTH = 1;
    final int DAY = 2;
    
    int noOfLeapYears(int year, int month){
        if (month <= 2)
            year--;
        return year/4 + year/400 - year/100;
    }
    int noOfDays(int year, int month, int day){
        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        totalDays += 365 * year + day;
        for (int m = 1; m < month; m++){
            totalDays += monthDays[m];
        }
        totalDays += noOfLeapYears(year, month);
        return totalDays;
    }
    
    int[] parseDate(String date){
        int[] d = new int[3];
        String[] data = date.split("-");
        d[YEAR] = Integer.parseInt(data[YEAR]);
        d[MONTH] = Integer.parseInt(data[MONTH]);
        d[DAY] = Integer.parseInt(data[DAY]);
        return d;
    }
    public int daysBetweenDates(String date1, String date2) {
        int[] d1 = parseDate(date1);
        int[] d2 = parseDate(date2);
        return Math.abs(noOfDays(d1[YEAR], d1[MONTH], d1[DAY]) - noOfDays(d2[YEAR], d2[MONTH], d2[DAY]));
        
    }
}