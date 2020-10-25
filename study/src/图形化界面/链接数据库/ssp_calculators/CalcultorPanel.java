package 图形化界面.链接数据库.ssp_calculators;

import javax.swing.*;
import java.awt.*;

public class CalcultorPanel extends JPanel{//主面板
    Color color1 = new Color(85, 87, 85, 161);
    public static boolean start=true;//新数字键输入的开始
    public static String result="";//保存中间结果的参数
    public static String lastcommand="=";//记录上一个运算符
    public static boolean firstDigit = true;//输入第一个数
    public CalcultorPanel() {//构造方法
        setLayout(new BorderLayout());//设置布局为边界布局
        ShowPanel showPanel=new ShowPanel();//新建结果展示面板
        showPanel.setBackground(color1);
        BTNPanel btnPanel=new BTNPanel();//新建按钮面板
        add(showPanel, BorderLayout.NORTH);//把结果面板放入主面板北部
        add(btnPanel,BorderLayout.CENTER);//把按钮面板放入主面板中间
    }
}
