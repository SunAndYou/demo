package study16_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientGuess {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Socket mysocket=null;
        DataInputStream inData=null;
        DataOutputStream outData=null;
        Thread thread ;
        ReadNumber readNumber=null;
        try{ mysocket=new Socket();
            readNumber = new ReadNumber();
            thread = new Thread(readNumber); //负责读取信息的线程
            System.out.print("输入服务器的 IP:");
            String IP = scanner.nextLine();
            System.out.print("输入端口号:");
            int port = scanner.nextInt();
            if(mysocket.isConnected()){}
            else{
                InetAddress address=InetAddress.getByName(IP);
                InetSocketAddress socketAddress=new InetSocketAddress(address,port);
                mysocket.connect(socketAddress);
                InputStream in= mysocket.getInputStream(); //mysocket 调用 getInputStream()返回输入流
                OutputStream out= mysocket.getOutputStream();//mysocket 调用 getOutputStream()返回输出流
                inData =new DataInputStream(in);
                outData = new DataOutputStream(out);
                readNumber.setDataInputStream(inData);
                readNumber.setDataOutputStream(outData);
                thread.start(); //启动负责读取随机数的线程
            }
        }
        catch(Exception e) {
            System.out.println("服务器已断开"+e);
        }
    }
}