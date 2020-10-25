package study16_3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) {
        ServerSocket server=null;
        ServerThread thread;
        Socket you=null;
        while(true) {
            try{ server= new ServerSocket(4331);//创建在端口 4331 上负责监听的 ServerSocket 对象
            }
            catch(IOException e1) {
                System.out.println("正在监听");
            }
            try{ you= server.accept(); // server 调用 accept()返回和客户端相连接的 Socket 对象
                System.out.println("客户的地址:"+you.getInetAddress());
            }
            catch (IOException e) {
                System.out.println("正在等待客户");
            }
            if(you!=null) {
                new ServerThread(you).start();
            }
        }
    }
}
class ServerThread extends Thread {
    Socket socket;
    ObjectInputStream in=null;
    ObjectOutputStream out=null;
    JFrame window,window1;
    JTextArea text,text1;
    ServerThread(Socket t) {
        socket=t;
        try { out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e) {}
        window =new JFrame();
        window1 = new JFrame();
        text = new JTextArea();
        for(int i=1;i<=20;i++) {
            text.append("你好,我是服务器上的文本区组件1\n");
        }
        text1 = new JTextArea();
        for(int i=1;i<=20;i++) {
            text1.append("你好,我是服务器上的文本区组件2\n");
        }
        text.setBackground(Color.yellow);
        text1.setBackground(Color.yellow);

        window.add(text);
        window1.add(text1);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void run() {
        try{ out.writeObject(window);
            out.writeObject(window1);
        }
        catch (IOException e) {
            System.out.println("客户离开");
        }
    }
}