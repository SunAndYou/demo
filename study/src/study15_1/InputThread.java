package study15_1;

import java.util.Scanner;
public class InputThread extends Thread {
    Scanner reader;
    Chinese hanzi;
    int score = 0;
    InputThread() {
        reader = new Scanner(System.in);
    }
    public void setChinese(Chinese hanzi) {
        this.hanzi = hanzi;
    }
    public void run() {
        while(true) {
            String str = reader.nextLine();
            char c = str.charAt(0);
            if(c==hanzi.getChinese()) {
                score++;
                System.out.printf("\t\t输入对了,目前分数%d\n",score);
            }
            else {
                System.out.printf("\t\t输入错了,目前分数%d\n",score);
            }
            if(c=='#')
                System.exit(0);
        }
    }
}