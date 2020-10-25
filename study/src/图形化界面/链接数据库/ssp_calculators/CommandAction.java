package 图形化界面.链接数据库.ssp_calculators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CommandAction implements ActionListener{//功能事件

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String string = e.getActionCommand();
        switch (string) {
            case "CE" -> {
                ShowPanel.display1.setText("");
                ShowPanel.display2.setText("0");
            }
            case "C" -> {
                CalcultorPanel.start = true;//新数字键输入的开始
                CalcultorPanel.result = "";//保存中间结果的参数
                CalcultorPanel.lastcommand = "=";//记录上一个运算符
                CalcultorPanel.firstDigit = true;//输入第一个数
                ShowPanel.display1.setText("");
                ShowPanel.display2.setText("0");
            }
//退格
            case "<--" -> {
                ShowPanel.display1.setText("");
                String text = ShowPanel.display2.getText();
                int i = text.length();
                if (i > 0) {
                    // 退格，将文本最后一个字符去掉
                    text = text.substring(0, i - 1);
                    if (text.length() == 0) {
                        // 如果文本没有了内容，则初始化计算器的各种值
                        ShowPanel.display2.setText("0");
                        CalcultorPanel.firstDigit = true;
                        CalcultorPanel.lastcommand = "=";
                    } else {
                        // 显示新的文本
                        ShowPanel.display2.setText(text);
                    }
                }
            }
            case "+/-" -> {
                String a1 = ShowPanel.display2.getText();
                ShowPanel.display1.setText("");
                if (a1.indexOf("-") == -1) {
                    if (Double.parseDouble(a1) != 0)
                        ShowPanel.display2.setText("-" + ShowPanel.display2.getText());
                } else {
                    ZeroText(Double.parseDouble(a1) * -1);
                }
                CalcultorPanel.result = a1;
            }
            default -> {
                CalcultorPanel.start = true;//新数字键的输入
                if (CalcultorPanel.lastcommand.equals("=")) //做一次运算
                {
                    CalcultorPanel.result = ShowPanel.display2.getText(); //获取操作数1
                } else {
                    if (CalcultorPanel.lastcommand.equals("%")) {
                        // 百分号运算，除以100
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        a1 = a1 / 100;
                        if (CalcultorPanel.result == "0.") //去除0.问题
                            ShowPanel.display1.setText(0 + "/100" + "=");
                        else ShowPanel.display1.setText(CalcultorPanel.result + "/100=");
                        ZeroText(a1);
                        CalcultorPanel.result = a1 + "";
                    } else if (CalcultorPanel.lastcommand.equals("²√")) {
                        // 平方根运算
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        a1 = Math.sqrt(a1);
                        if (CalcultorPanel.result == "0.")//去除0.问题
                            ShowPanel.display1.setText("²√(" + 0 + ")" + "=");
                        else ShowPanel.display1.setText("²√" + "(" + CalcultorPanel.result + ")=");
                        ZeroText(a1);
                        CalcultorPanel.result = a1 + "";
                    } else if (CalcultorPanel.lastcommand.equals("²√")) {
                        // 平方根运算
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        a1 = Math.sqrt(a1);
                        if (CalcultorPanel.result == "0.")//去除0.问题
                            ShowPanel.display1.setText("²√(" + 0 + ")" + "=");
                        else ShowPanel.display1.setText("²√" + "(" + CalcultorPanel.result + ")=");
                        ZeroText(a1);
                        CalcultorPanel.result = a1 + "";
                    } else if (CalcultorPanel.lastcommand.equals("X²")) {
                        double a1 = Double.parseDouble(CalcultorPanel.result);
//                    double a2=Double.parseDouble(ShowPanel.display2.getText());
//                    double s=Math.pow(a1,a2);
                        double s = a1 * a1;
//                    if (CalcultorPanel.result=="0.") {//去除0.问题
//                        if(ShowPanel.display2.getText()=="0.")
////                            ShowPanel.display1.setText("pow("+0+","+0+")"+"=");
//                            ShowPanel.display1.setText(a1 + "*" + a1 + "=");
//                        else
////                            ShowPanel.display1.setText("pow("+0+","+ShowPanel.display2.getText()+")"+"=");
//                            ShowPanel.display1.setText(0+"*"+ShowPanel.display2.getText()+"=");
//                    }else if(ShowPanel.display2.getText()=="0.") {
////                        ShowPanel.display1.setText("pow("+CalcultorPanel.result+","+0+")"+"=");
//                        ShowPanel.display1.setText(CalcultorPanel.result+"*"+0+"=");
//                    }else
////                        ShowPanel.display1.setText("pow"+"("+CalcultorPanel.result+","+ShowPanel.display2.getText()+")=");
                        ShowPanel.display1.setText(CalcultorPanel.result + "²" + "=");
                        ZeroText(s);
                        CalcultorPanel.result = a1 + "";
                    } else if (CalcultorPanel.lastcommand.equals("1/x")) {
                        // 倒数运算
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        if (a1 == 0.0) {
                            // 操作不合法
                            ShowPanel.display2.setText("零没有倒数");
                        } else {
                            a1 = 1 / a1;
                            ShowPanel.display1.setText("1" + "/" + CalcultorPanel.result + "=");
                            ZeroText(a1);
                            CalcultorPanel.result = a1 + "";
                        }
                    } else if (CalcultorPanel.lastcommand.equals("+")) {
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        double a2 = Double.parseDouble(ShowPanel.display2.getText());
                        double s = a1 + a2;
                        if (CalcultorPanel.result == "0.") {//去除0.问题
                            if (ShowPanel.display2.getText() == "0.")
                                ShowPanel.display1.setText(0 + "+" + 0 + "=");
                            else ShowPanel.display1.setText(0 + "+" + ShowPanel.display2.getText() + "=");
                        } else if (ShowPanel.display2.getText() == "0.") {
                            ShowPanel.display1.setText(CalcultorPanel.result + "+" + 0 + "=");
                        } else
                            ShowPanel.display1.setText(CalcultorPanel.result + "+" + ShowPanel.display2.getText() + "=");
                        ZeroText(s);
                        CalcultorPanel.result = s + "";
                    } else if (CalcultorPanel.lastcommand.equals("-")) {
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        double a2 = Double.parseDouble(ShowPanel.display2.getText());
                        double s = a1 - a2;
                        if (CalcultorPanel.result == "0.") {//去除0.问题
                            if (ShowPanel.display2.getText() == "0.")
                                ShowPanel.display1.setText(0 + "-" + 0 + "=");
                            else ShowPanel.display1.setText(0 + "-" + ShowPanel.display2.getText() + "=");
                        } else if (ShowPanel.display2.getText() == "0.") {
                            ShowPanel.display1.setText(CalcultorPanel.result + "-" + 0 + "=");
                        } else
                            ShowPanel.display1.setText(CalcultorPanel.result + "-" + ShowPanel.display2.getText() + "=");
                        ZeroText(s);
                        CalcultorPanel.result = s + "";
                    } else if (CalcultorPanel.lastcommand.equals("*")) {
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        double a2 = Double.parseDouble(ShowPanel.display2.getText());
                        double s = a1 * a2;
                        if (CalcultorPanel.result == "0.") {//去除0.问题
                            if (ShowPanel.display2.getText() == "0.")
                                ShowPanel.display1.setText(0 + "*" + 0 + "=");
                            else ShowPanel.display1.setText(0 + "*" + ShowPanel.display2.getText() + "=");
                        } else if (ShowPanel.display2.getText() == "0.") {
                            ShowPanel.display1.setText(CalcultorPanel.result + "*" + 0 + "=");
                        } else
                            ShowPanel.display1.setText(CalcultorPanel.result + "*" + ShowPanel.display2.getText() + "=");
                        ZeroText(s);
                        CalcultorPanel.result = s + "";
                    } else if (CalcultorPanel.lastcommand.equals("/")) {
                        // 除法运算
                        // 如果当前结果文本框中的值等于0
                        double a1 = Double.parseDouble(CalcultorPanel.result);
                        double a2 = Double.parseDouble(ShowPanel.display2.getText());
                        if (a2 == 0.0) {
                            // 操作不合法
                            ShowPanel.display2.setText("除数不能为零");
                        } else {
                            double s = a1 / a2;
                            if (CalcultorPanel.result == "0.")//去除0.问题
                                ShowPanel.display1.setText(0 + "/" + ShowPanel.display2.getText() + "=");
                            else
                                ShowPanel.display1.setText(CalcultorPanel.result + "/" + ShowPanel.display2.getText() + "=");
                            ZeroText(s);
                            CalcultorPanel.result = s + "";
                        }
                    }
                }
                CalcultorPanel.lastcommand = e.getActionCommand();//获取当前的运算符
                CalcultorPanel.firstDigit = true;
            }
        }
    }
    public void ZeroText(double s) {
        long t1;
        double t2;
        t1 = (long) s;
        t2 = s-t1;
        if (t2 == 0) {
            ShowPanel.display2.setText(String.valueOf(t1));
        } else {
            ShowPanel.display2.setText(String.valueOf(s));
        }
    }
}


