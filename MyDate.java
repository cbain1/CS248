//Catherine Bain


import java.util.*;

public class MyDate implements DateInterface {


    public MyDate() {}

    int day;
    int doweek; 
    int month;
    int year;

    /** @return the day of the month (1-31) */
    public int getDay() {
        return day;
    }
    /** @return the day of the week (0-6) */
    public int getDow() {
        return doweek;
    }
    /** @return the month of the year (1-12) */
    public int getMonth() {
        return month;
    }
    /** @return the year (four digits) */
    public int getYear(){
        return year;
    }
    /** sets the date
        @param m the month of the year (1-12)
        @param d the day of the mongth (1-31)
        @param y the year (four digits)
        @param dow the day of the week (0-6) */
    public void set(int m, int d, int y, int dow) {
        day=d;
        doweek=dow;
        month=m;
        year=y;
    }
    /** moves the date forward by exactly one day */
    public void tomorrow() {

        // month has 31 days
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day == 31 && month !=12) {
                day = 1;
                month++;
            }
                // if month is Jan.
            else if (day == 31) {
                month = 1;
                year++;
                day = 1;
            }
            else if (day < 31)
                day++;
        }
        // month has 30 days
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 30) {
                day = 1;
                month++; 
            }
            else if (day < 30) 
                day++;
        }
        // if leap year feb.
        else if ((month == 2 && year%4 == 0 && year%100!=0) || (month == 2 && year%400 == 0)) {
            if (day == 29) {
                day = 1; 
                month++;
            }
            else if (day <29)
                day++;
        }
        // if not leap year feb.
        else if (month == 2) {
            if (day == 28) {
                day = 1;
                month++;
            }
            else if (day <28)
                day++;
        }
        doweek = (doweek+1)%7;
    }

    /** @return the date as a String in the format "Monday March 18, 2002" */
    public String toString() {
        return (dayWeek() + " " + month() + " " + day + ", " + year);
    }

    public void yesterday() {
        if (year > 1752) {
            if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day > 1)
                        day--;
                    else if (day == 1) {
                        day = 31;
                        month--;
                    }
                }
                else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                    if (day > 1)
                        day--;
                    else if (day == 1) {
                        // leap year
                        if ((month == 3 && year%4 == 0 && year%100!=0) || (month == 3 && year%400 == 0)) {
                            day = 29;
                            month--;
                        }
                        else if (month == 3) {
                            day = 28;
                            month--;
                        }
                        else if (month == 1) {
                            day = 31;
                            year--;
                            month = 12;
                        }
                        else if (month == 8) {
                            day = 31;
                            month--;
                        }
                        else {
                            day = 30;
                            month--;
                        }
                    }  
                }
                doweek = (doweek+6)%7;   
        }
        else if (year <= 1752) {
            if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 1) {
                    day--;
                    if (year == 1752 && day == 13 && month == 9)
                        day =2;
                }
                else if (day == 1) {
                    day = 31;
                    month--;
                }
            }
            else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (day > 1)
                    day--;
                else if (day == 1) {
                    // leap year
                    if (month == 3 && year%4 == 0)  {
                        day = 29;
                        month--;
                    }
                    else if (month == 3) {
                        day = 28;
                        month--;
                    }
                    else if (month == 1) {
                        day = 31;
                        year--;
                        month = 12;
                    }
                    else if (month == 8) {
                        day = 31;
                        month--;
                    }
                    else {
                        day = 30;
                        month--;
                    }
                }  
            }
            doweek = (doweek+6)%7;    
        }
    }
    /** @return the date as a String in the format "Monday March 18, 2002" */
    

    public String dayWeek() {
        if (doweek == 0) 
            return "Sunday";
        if (doweek == 1)
            return "Monday";
        if (doweek == 2)
            return "Tuesday";
        if (doweek == 3) 
            return "Wendesday";
        if (doweek == 4)
            return "Thursday";
        if (doweek == 5) 
            return "Friday";
        if (doweek == 6)
            return "Saturday";
        return "fail";

    }

    public String month() {
        if (month == 1)
            return "January";
        if (month == 2)
            return "February";
        if (month == 3) 
            return "March";
        if (month == 4)
            return "April";
        if (month == 5)
            return "May";
        if (month == 6)
            return "June";
        if (month == 7)
            return "July";
        if (month == 8)
            return "August"; 
        if (month == 9)
            return "September";
        if (month == 10)
            return "October";
        if (month == 11)
            return "November";
        if (month == 12)
            return "December";
        return "fail";
    }

    /** sets the date to today;
        make this empty {} unless you do the extra credit. */
    public void today() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);

        doweek = today.get(Calendar.DAY_OF_WEEK);
        day = today.get(Calendar.DAY_OF_MONTH);
        month = today.get(Calendar.MONTH);
        month++;
        year = today.get(Calendar.YEAR);

    }

}
