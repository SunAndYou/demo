package study16_5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerImage {
    public static void main(String args[]) {
        DatagramPacket pack=null;
        DatagramSocket mailReceive=null;
        ServerThread thread;
        byte b[]=new byte[8192];
        InetAddress address=null;
        pack=new DatagramPacket(b,b.length);
        while(true) {
            try{ mailReceive= new DatagramSocket(1234);
            }
            catch(IOException e1) {
                System.out.println("正在等待");
            }
            try{ mailReceive.receive(pack);
                address=pack.getAddress();
                System.out.println("客户的地址:"+address);
            }
            catch (IOException e) {}
            if(address!=null) {
                new ServerThread(address).start();
            }
        }
    }
}