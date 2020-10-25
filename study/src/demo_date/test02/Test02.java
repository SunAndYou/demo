package demo_date.test02;

import demo_date.test01.Demo_Time;

import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
        Demo();
        Demo02();
        Demo03();
    }

    private static void Demo03() {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);//当前系统时间到时间原点一共经历了多少毫秒
    }

    private static void Demo02() {
        Date date = new Date(0L);
        System.out.println(date);//Thu Jan 01 08:00:00 CST 1970
        Date date1 = new Date(1482189315404L);
        System.out.println(date1);//Tue Dec 20 07:15:15 CST 2016
    }

    private static void Demo() {
        Date date = new Date();
        System.out.println(date);//系统当前时间
    }
}
