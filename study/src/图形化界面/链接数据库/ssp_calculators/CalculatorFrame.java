package 图形化界面.链接数据库.ssp_calculators;

import javax.swing.*;

public class CalculatorFrame extends JFrame{
        public CalculatorFrame() {//构造函数
            JFrame jFrame = new JFrame("计算器");//新建窗体，计算器
            jFrame.setSize(430,590);//设置窗体初始大小
            CalcultorPanel calcultorPanel=new CalcultorPanel();//新建面板
            jFrame.getContentPane().add(calcultorPanel);//给当前窗体添加主面板
            jFrame.setLocationRelativeTo(null);//窗体默认居中显示
            jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗体关闭规则
            jFrame.setVisible(true);//设置窗体为可见
        }
    }
