package study_my;

public class t4 {
    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 1) continue;
            if (i == 2) break;
            a += i;
        }
        System.out.println(a);
    }
}
