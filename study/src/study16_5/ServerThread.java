package study16_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class ServerThread extends Thread {
    InetAddress address;
    DataOutputStream out = null;
    DataInputStream in = null;
    String s = null;

    ServerThread(InetAddress address) {
        this.address = address;
    }

    public void run() {
        FileInputStream in;
        byte b[] = new byte[8192];
        try {
            in = new FileInputStream("a.jpg");
            int n = -1;
            while ((n = in.read(b)) != -1) {
                DatagramPacket data = new DatagramPacket(b, n, address, 5678);
                DatagramSocket mailSend = new DatagramSocket();
                mailSend.send(data);
            }
            in.close();
            byte end[] = "end".getBytes();
            DatagramPacket data = new DatagramPacket(end, end.length, address, 5678);
            DatagramSocket mailSend = new DatagramSocket();
            mailSend.send(data);
        } catch (Exception e) {
        }
    }
}