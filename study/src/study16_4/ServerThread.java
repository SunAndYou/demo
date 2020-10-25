package study16_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

class ServerThread extends Thread {
    Socket socket;
    DataInputStream in=null;
    DataOutputStream out=null;
    static int time = 0;

    ServerThread(Socket t) {
        socket=t;
        try { out=new DataOutputStream(socket.getOutputStream());
            in=new DataInputStream(socket.getInputStream());
        }
        catch (IOException e) {}
    }
    public void run() {
        try{
            while(true) {
                String str = in.readUTF();
                boolean boo =str.startsWith("Y")||str.startsWith("y");
                if(boo) {
                    out.writeUTF("给你一个 1 至 100 之间的随机数,请猜它是多少呀!");
                    Random random=new Random();
                    int realNumber = random.nextInt(100)+1;
                    handleClientGuess(realNumber);
                    out.writeUTF("询问:想继续玩输入 Y，否则输入 N:");
                }
                else {
                    return;
                }
            }
        }
        catch(Exception exp){}
    }
    public void handleClientGuess(int realNumber){
        while(true) {
            time++;
            try{ int clientGuess = in.readInt();
                System.out.println(clientGuess);
                if(clientGuess>realNumber)
                    out.writeUTF("第"+time+"次"+"猜大了");
                else if(clientGuess<realNumber)
                    out.writeUTF("第"+time+"次"+"猜小了");
                else if(clientGuess==realNumber) {
                    out.writeUTF("第"+time+"次"+"猜对了！");
                    break;
                }
            }
            catch (IOException e) {
                System.out.println("客户离开");
                return;
            }
        }
    }
}