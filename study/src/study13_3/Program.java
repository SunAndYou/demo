package study13_3;

import java.util.*;
public class Program implements Comparable<Program> {
    Date time=null;
    String name;
    Program(String s,int year,int month,int day,int hour,int minute,int second) {
        name=s;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day,hour,minute,second);
        long n = calendar.getTimeInMillis();
        time = new Date(n);
    }
    public int compareTo(Program b) { // 两个 Program 对象相等当且仅当二者的 time 相等
        int m = 0;
        if(time.equals(b.getDate()))
            m = 0;
        else if(time.after(b.getDate()))
            m = 1;
        else if(time.before(b.getDate()))
            m = -1;
        return m;
    }
    public String getName() {
        return name;
    }
    public Date getDate() {
        return time;
    }
}