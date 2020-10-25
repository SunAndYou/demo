package study_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentJFrame {
    public void setJFrame(){
        /*
         * 设置窗口基本样式
         */
        JFrame jframe = new JFrame("学生成绩管理系统");
        jframe.setSize(500, 382);
        jframe.setLocation(100, 100);
        jframe.setLayout(null);
        /*
         * 创建容器增加按钮
         */
        Container c = jframe.getContentPane();

        JButton b =new JButton("增加");
        JButton b1 =new JButton("删除");
        JButton b2 =new JButton("修改");
        JButton b3 =new JButton("查看");
        ImageIcon image = new ImageIcon("F:\\java实验报告作业2020\\school.jpg");
        final JLabel l = new JLabel();
        l.setIcon(image);
        l.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        JLabel l1 = new JLabel("欢迎来到学生成绩管理系统");
        l1.setBounds(100, 0, 400, 180);
        Font font = new Font("楷体",Font.BOLD,30);
        l1.setFont(font);
        b.setBounds(120, 250, 60, 30);
        b1.setBounds(190, 250, 60, 30);
        b2.setBounds(260, 250, 60, 30);
        b3.setBounds(330, 250, 60, 30);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentJDialogAdd(jframe).setVisible(true);;
            }
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new StudentJDialogDelete(jframe).setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new StudentJDialogUpdate(jframe).setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new StudentJDialogSelect(jframe).setVisible(true);
            }
        });
        c.add(b);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(l1);
        c.add(l);
        /*
         * 设置窗口可见与关闭方式
         */
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        StudentJFrame f =new StudentJFrame();
        f.setJFrame();
    }
}