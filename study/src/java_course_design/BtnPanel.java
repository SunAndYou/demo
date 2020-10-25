package java_course_design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class BtnPanel extends JPanel {

    Color color1 = new Color(226, 224, 224, 255);//自定义颜色1,数字颜色
    Color color2 = new Color(212, 208, 208, 255);//自定义颜色2，符号颜色
    Color color3 = new Color(119, 188, 222,255);//自定义颜色3，等号专用颜色

    public BtnPanel() {//构造方法
        setLayout(new GridLayout(7, 4, 2, 2));//使用网格布局，按照win10计算器界面，构造6行4列的网格
        String[] keys = {
                "%", "CE", "C", "←","sin","cos","tan","n!",//新加入sin、cos、tan等运算
                "1/x", "x²", "²√", "÷", "7", "8",
                "9", "×", "4", "5", "6", "-", "1",
                "2", "3", "+", "+/-", "0", ".", "="};//定义一个字符串数组存键盘上的按键

        PanelAction panelAction = new PanelAction();//数字事件监听器
        ButtonAction btnAction = new ButtonAction();//按钮事件监听器

        for (int i = 0; i < 12; i++)//"%", "CE", "C", "←","sin","cos","tan","n!","1/x", "x²", "²√", "÷"，
            addButton(keys[i], btnAction);//调用自定义方法addButton，传递参数

        for (int i = 12; i < keys.length; i++) {
            if ((i + 1) % 4 == 0||i == 24)//"×","-","+", "+/-",
                addButton(keys[i], btnAction);//按钮事件监听器
            else
                addButton(keys[i], panelAction);//面板事件监听器
        }
    }

    void addButton(String label, ActionListener actionListener) {//自定义添加按钮方法
        JButton button = new JButton(label);//新建按钮，按钮展示label接受的字符
        button.setFont(new Font("微软雅黑", Font.BOLD, 20));//设置按钮上的字体
        button.addActionListener(actionListener);//为按钮添加事件监听器
        String string = button.getActionCommand();//获取按钮上的字符数值
        if (string.equals("=")) {//利用循环为不同类型按钮上色
            button.setBackground(color3);//设置按钮背景色为自定义颜色3
        } else if (string.equals("0") || string.equals("1") || string.equals("2")
                || string.equals("3") || string.equals("4") || string.equals("5")
                || string.equals("6") || string.equals("7") || string.equals("8")
                || string.equals("9") || string.equals("+/-") || string.equals(".")) {
            button.setBackground(color1);//设置按钮背景色为自定义颜色1
        } else {
            button.setBackground(color2);//设置按钮背景色为自定义颜色2
        }
        button.setForeground(Color.BLACK);//设置按钮的前景颜色，即按钮上字符的颜色
        button.setBorderPainted(false);//除去按钮的边框
        add(button);//添加按钮
    }

}