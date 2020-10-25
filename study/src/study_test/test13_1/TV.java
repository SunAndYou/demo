package study_test.test13_1;

public class TV implements Comparable<TV> {
    int price = 0;
    String name;

    TV(String n, int p) {
        name = n;
        price = p;

    }

    public int compareTo(TV tv) { // 两个 Student 对象相等当且仅当二者的 height 值相等
        return (this.price - tv.price);
    }
}