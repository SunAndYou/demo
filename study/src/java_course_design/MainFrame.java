package java_course_design;

import javax.swing.*;

public class MainFrame extends JFrame {//继承于JFrame

    public MainFrame() {//构造方法
        new JFrame();//新建窗体，计算器
        setTitle("计算器");//标题为计算器
        setSize(430, 600);//设置窗体的大小
        setLocationRelativeTo(null);//设置窗体默认居中
        MainPanel mainPanel = new MainPanel();//新建面板
        add(mainPanel);//窗体中增加面板
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗体关闭规则
        setVisible(true);//设置窗体可见
    }
}
