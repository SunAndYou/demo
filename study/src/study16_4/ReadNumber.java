package study16_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

class ReadNumber implements Runnable {
    Scanner scanner = new Scanner(System.in);
    DataInputStream in;
    DataOutputStream out;
    public void setDataInputStream(DataInputStream in) {
        this.in = in;
    }
    public void setDataOutputStream(DataOutputStream out) {
        this.out = out;
    }
    public void run() {
        try {
            out.writeUTF("Y");
            while(true) {
                String str = in.readUTF();
                System.out.println(str);
                if(!str.startsWith("询问")) {
                    if(str.startsWith("猜对了"))
                        continue;
                    System.out.print("好的，我输入猜测:");
                    int myGuess = scanner.nextInt();
                    String enter = scanner.nextLine(); //消耗多余的回车
                    out.writeInt(myGuess);
                }
                else {
                    System.out.print("好的，我输入 Y 或 N:");
                    String myAnswer = scanner.nextLine();
                    out.writeUTF(myAnswer);
                }
            }
        }
        catch(Exception e) {
            System.out.println("与服务器已断开"+e);
            return;
        }
    }
}