package java_course_design;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {//面板，继承于JPanel，可省略面板命名

    public static boolean start = true;//新数字键输入的开始
    public static String result = "";//保存中间结果的参数
    public static String lastcommand = "=";//记录上一个运算符
    public static boolean firstDigit = true;//输入第一个数

    public MainPanel() {//构造面板方法
        setLayout(new BorderLayout());//设置布局为边界布局
        ShowsPanel showsPanel = new ShowsPanel();//新建结果展示面板
        BtnPanel btnPanel = new BtnPanel();//新建按钮面板
        add(showsPanel, BorderLayout.NORTH);//把结果展示面板放入面板北部
        add(btnPanel, BorderLayout.CENTER);//把按钮面板放入面板中间
    }
}