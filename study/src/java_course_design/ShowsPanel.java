package java_course_design;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowsPanel extends JPanel {
    Color color1 = new Color(128, 127, 127, 233);//自定义颜色1
    Color color2 = new Color(50, 50, 50, 233);//自定义颜色2
    Color color3 = new Color(13, 206, 189, 253);//自定义颜色3

    public static JLabel display1;//整式，标签1
    public static JLabel display2;//输入，标签2
    public static JLabel display3;//日期，标签3


    public ShowsPanel() {
        SimpleDateFormat time = new SimpleDateFormat("YYYY-MM-dd");//新建日期与格式
        String TimeString = time.format(new java.util.Date());//日期用String存入
        display3 = new JLabel("☆**********************★[" + "日期：" + TimeString + "]★**********************☆", JLabel.CENTER);
        //标签3，用来展示日期，放在面板中间位置
        setBackground(Color.WHITE);//显示面板的背景颜色
        display1 = new JLabel("", JLabel.RIGHT);//标签1，作记录使用，初始值为空
        display2 = new JLabel("0", JLabel.RIGHT);//标签2，输入界面数字，初始值为0
        display1.setFont(new Font("微软雅黑", Font.BOLD, 20));//设置标签1（整体的算式）字体样式，状态与大小
        display2.setFont(new Font("微软雅黑", Font.BOLD, 45));//设置标签2（当前键入的数值）字体样式，状态与大小
        display3.setFont(new Font("微软雅黑", Font.BOLD, 12));//设置标签2（当前键入的数值）字体样式，状态与大小
        display1.setForeground(color1);//设置标签1的前景颜色，即字体颜色
        display2.setForeground(color2);//设置标签2的前景颜色，即字体颜色
        display3.setForeground(color3);//设置标签3的前景颜色，即字体颜色
        display1.setPreferredSize(new Dimension(430, 60));//设置标签初始高度
        display2.setPreferredSize(new Dimension(430, 90));//同上
        setLayout(new BorderLayout());//设置显示面板布局为边界布局
        add(display3, BorderLayout.NORTH);//在显示面板北部添加日期标签
        add(display1, BorderLayout.CENTER);//在显示面板中间添加历史标签
        add(display2, BorderLayout.SOUTH);//在显示面板南部添加输入标签
    }

}
