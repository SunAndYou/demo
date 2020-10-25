package 图形化界面.链接数据库.ssp_calculators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BTNPanel extends JPanel {//按钮面板
    public BTNPanel() {//构造方法
        setLayout(new GridLayout(6, 4));//使用网格布局，按照win10计算器界面，构造6行4列网格
        InsertAction insertAction = new InsertAction();
        CommandAction commandAction = new CommandAction();
        addButton("%", commandAction);
        addButton("CE", commandAction);
        addButton("C", commandAction);
        addButton("<--", commandAction);
        addButton("1/x", commandAction);
        addButton("X²", commandAction);
        addButton("²√", commandAction);
        addButton("/", commandAction);
        addButton("7", insertAction);
        addButton("8", insertAction);
        addButton("9", insertAction);
        addButton("*", commandAction);
        addButton("4", insertAction);
        addButton("5", insertAction);
        addButton("6", insertAction);
        addButton("-", commandAction);
        addButton("1", insertAction);
        addButton("2", insertAction);
        addButton("3", insertAction);
        addButton("+", commandAction);
        addButton("+/-", commandAction);
        addButton("0", insertAction);
        addButton(".", insertAction);
        addButton("=", commandAction);
    }

    void addButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.setFont(new Font("微软雅黑",Font.BOLD,20));
        button.addActionListener(actionListener);
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        add(button);
    }
}
