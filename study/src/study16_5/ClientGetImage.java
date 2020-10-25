package study16_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientGetImage extends JFrame implements Runnable, ActionListener {
    JButton b=new JButton("获取文本");
    JTextArea showArea;
    ClientGetImage() {
        super("I am a client");
        setSize(500,500);
        setVisible(true);
        b.addActionListener(this);
        add(b, BorderLayout.NORTH);
        showArea=new JTextArea();
        showArea.setFont(new Font("",Font.BOLD,20));

        Thread thread=new Thread(this);
        add(new JScrollPane(showArea),BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        thread.start();
    }
    public void actionPerformed(ActionEvent event) {
        byte b[]="请发文件".trim().getBytes();
        try{ InetAddress address=InetAddress.getByName("127.0.0.1");
            DatagramPacket data= new DatagramPacket(b,b.length, address,1234);//创建 data，该数据包的目标地址和端口分别是
            //address 和 1234，其中的数据为数组 b 的全部字节
            DatagramSocket mailSend= new DatagramSocket();//创建负责发送数据的 mailSend 对象
            mailSend.send(data); //mailSend 发送数据 data
        }
        catch(Exception e){}
    }
    public void run() {
        DatagramPacket pack=null;
        DatagramSocket mailReceive=null;
        byte b[]=new byte[8192];
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try{ pack=new DatagramPacket(b,b.length);
            mailReceive = new DatagramSocket(5678);//创建在端口 5678 负责收取数据包的 mailReceive 对象
        }
        catch(Exception e){}
        try{ while(true)
        { mailReceive.receive(pack);
            String message=new String(pack.getData(),0,pack.getLength());
            if(message.startsWith("end")) {
                break;
            }

            String[] split = message.split("\\n");
            for (String s1 : split) {
                showArea.append(s1+"\r\n");
            }
        }
            validate();
        }
        catch(IOException e){}
    }
    public static void main(String args[]) {

        new ClientGetImage();
    }
}