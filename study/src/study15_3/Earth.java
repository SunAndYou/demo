package study15_3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Earth extends JLabel implements ActionListener {
    JLabel moon,weixin;  //显示月亮之外观
    Timer timer;
    double pointX[]=new double[360],
            pointY[]=new double[360];
    int w=200,h=200,i=0;
    Earth() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(w,h));
        timer = new Timer(20,this); //创建timer,振铃间隔是20毫秒当前Earth对象为其监视器
        setIcon(new ImageIcon("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\earth.jpg"));
        setHorizontalAlignment(SwingConstants.CENTER);
        moon=new JLabel(new ImageIcon("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\moon.jpg"),SwingConstants.CENTER);
        add(moon);
        moon.setPreferredSize(new Dimension(200,200));

        weixin = new JLabel(new ImageIcon("H:\\Users\\1\\IdeaProjects\\ssp_basic01\\study\\weixing.jpg"),SwingConstants.RIGHT);
        add(weixin);
        weixin.setPreferredSize(new Dimension(150,150));

        pointX[0]=0;
        pointY[0]=h/2;
        double angle=1*Math.PI/180;   //刻度为1度
        for(int i=0;i<359;i++) {      //计算出数组中各个元素的值
            pointX[i+1]=pointX[i]*Math.cos(angle)-Math.sin(angle)*pointY[i];
            pointY[i+1]=pointY[i]*Math.cos(angle)+pointX[i]*Math.sin(angle);
        }
        for(int i=0;i<360;i++) {
            pointX[i]=0.8*pointX[i]+w/2;    //坐标缩放、平移
            pointY[i]=0.8*pointY[i]+h/2;
        }
        timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        i=(i+1)%360;
        moon.setLocation((int)pointX[i]-30,(int)pointY[i]-30);
        weixin.setLocation((int)pointX[i]-30,(int)pointY[i]-30);
    }
}