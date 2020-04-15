/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Arrays;



public class Calendar {
    private int day;
    private int month;
    private int year;

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    
    public int getDayOfTheWeek(){
        int q = this.day;
        int y = this.year;
        int m = this.month;
        if (m == 1){
            m = 13;
            y--;
        }
        if (m == 2){
            m = 14;
            y--;
        }
        int k = y % 100;
        int j = y/100;
        int h = (q + 13*(m+1)/5 + k + k/4 + j/4 - 2*j) % 7;
        int d = ((h + 5) % 7) + 1;
        return d;
    }
    
    public int daysInMonths() {
        int[] daysInMonths = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonths[getMonth()-1];
    }
    public void nextMonth() {
        this.day = 1;
        if (this.month == 12) {
            this.year++;
            this.month = 1;
        } else {
            this.month++;
        }
    }

    public void prevMonth() {
        this.day = 1;
        if (this.month == 1) {
            this.month = 12;
            this.year--;
        } else {
            this.month--;
        }
    }
    
   
    
    public String getCalendar() {
        StringBuilder calendar = new StringBuilder();
        calendar.append(String.format("%2d %4d%n", month,year));
        String[] week = new String[] {"PO","UT","ST","CT","PA","SO","NE"};
        calendar.append(Arrays.toString(week));
        int[] days = new int[7];
        int ind = getDayOfTheWeek();
        int citac1 = 1;
        int citac2 = 31;
        int daysInMonth = daysInMonths();
        if(getMonth() == 3){
        citac2 = 29;
        } else if (daysInMonth == 31 && getMonth() != 1 && getMonth() != 8 ){
            citac2 = 30;
        }
        for (int i = ind; i < days.length; i++) {
            days[i] = citac1++;   
        }
        for (int i = ind -1; i >= 0; i--) {
            days[i] = citac2;
            citac2--;
        }
        calendar.append("\n");
        calendar.append(Arrays.toString(days));
        for (int i = 0; i < 5; i++) {
            calendar.append("\n");
            for (int j = 0; j < days.length; j++) {
                if(citac1<= daysInMonths()){
                days[j] = citac1;
                citac1++;
                } else {
                    citac1 = 1;
                    days[j] = citac1++;
                }
            }
            calendar.append(Arrays.toString(days));
        }
        return calendar.toString();
    }
    
    public static void main(String[] args) {
        Calendar k = new Calendar(7,8,2020);
        System.out.println(k.getDayOfTheWeek());
        System.out.println(k.getCalendar());
        
    }
    
}
