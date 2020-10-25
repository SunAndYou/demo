package study15_2;

public class TwoThreadGuessNumber {
    public static void main(String args[]) {
        Number number=new Number();
        number.giveNumberThread.start();
        number.guessNumberThread1.start();
        number.guessNumberThread2.start();
    }
}