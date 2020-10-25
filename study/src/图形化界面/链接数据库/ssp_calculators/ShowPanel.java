package 图形化界面.链接数据库.ssp_calculators;

import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JPanel {
    public static JLabel display1;//显示
    public static JLabel display2;

    public ShowPanel(){//结果面板
        display1 = new JLabel("",JLabel.RIGHT);//标签1，作记录使用，初始值为空
        display2 = new JLabel("0",JLabel.RIGHT);//标签2，输入界面数字，初始值为0
        display1.setFont(new Font("微软雅黑",Font.BOLD,20));//设置字体样式，状态与大小
        display2.setFont(new Font("微软雅黑",Font.BOLD,40));
        display1.setPreferredSize(new Dimension(300,50));//设置初始高度
        display2.setPreferredSize(new Dimension(300,80));//同上
        setLayout(new BorderLayout());//设置结果面板布局为边界布局
        add(display1,BorderLayout.NORTH);//在结果面板北部添加历史标签
        add(display2,BorderLayout.CENTER);//在结果面板中间添加输入标签
    }
}
