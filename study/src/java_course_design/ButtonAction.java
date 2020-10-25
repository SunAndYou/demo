package java_course_design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonAction implements ActionListener {//功能事件

    public void actionPerformed(ActionEvent e) {
        String string = e.getActionCommand();
        switch (string) {//选择分支函数
            case "CE" -> {
                ShowsPanel.display1.setText("");
                ShowsPanel.display2.setText("0");
            }
            case "C" -> {
                MainPanel.start = true;//新数字键输入的开始
                MainPanel.result = "";//保存中间结果的参数
                MainPanel.lastcommand = "=";//记录上一个运算符
                MainPanel.firstDigit = true;//输入第一个数
                ShowsPanel.display1.setText("");
                ShowsPanel.display2.setText("0");
            }//退格
            case "←" -> {
                ShowsPanel.display1.setText("");
                String text = ShowsPanel.display2.getText();
                int i = text.length();
                if (i > 0) {// 退格，将文本最后一个字符去掉
                    text = text.substring(0, i - 1);
                    if (text.length() == 0) {
                        // 如果文本没有了内容，则初始化计算器的各种值
                        ShowsPanel.display2.setText("0");
                        MainPanel.firstDigit = true;
                        MainPanel.lastcommand = "=";
                    } else {
                        // 显示新的文本
                        ShowsPanel.display2.setText(text);
                    }
                }
            }
            case "+/-" -> {
                String a1 = ShowsPanel.display2.getText();
                ShowsPanel.display1.setText("");
                if (a1.indexOf("-") == -1) {
                    if (Double.parseDouble(a1) != 0)
                        ShowsPanel.display2.setText("-" + ShowsPanel.display2.getText());
                } else {
                    ZeroText(Double.parseDouble(a1) * -1);
                }
                MainPanel.result = a1;
            }
            default -> {
                MainPanel.start = true;//新数字键的输入
                if (MainPanel.lastcommand.equals("=")) //做一次运算
                {
                    MainPanel.result = ShowsPanel.display2.getText(); //获取操作数1
                } else {
                    if (MainPanel.lastcommand.equals("%")) {
                        // 百分号运算，除以100
                        double a1 = Double.parseDouble(MainPanel.result);
                        a1 = a1 / 100;
                        if (MainPanel.result == "0.") //去除0.问题
                            ShowsPanel.display1.setText(0 + "/100" + "=");
                        else ShowsPanel.display1.setText(MainPanel.result + "/100=");
                        ZeroText(a1);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("²√")) {
                        // 平方根运算
                        double a1 = Double.parseDouble(MainPanel.result);
                        a1 = Math.sqrt(a1);
                        if (MainPanel.result == "0.")//去除0.问题
                            ShowsPanel.display1.setText("²√(" + 0 + ")" + "=");
                        else ShowsPanel.display1.setText("²√" + "(" + MainPanel.result + ")=");
                        ZeroText(a1);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("²√")) {
                        // 平方根运算
                        double a1 = Double.parseDouble(MainPanel.result);
                        a1 = Math.sqrt(a1);
                        if (MainPanel.result == "0.")//去除0.问题
                            ShowsPanel.display1.setText("²√(" + 0 + ")" + "=");
                        else ShowsPanel.display1.setText("²√" + "(" + MainPanel.result + ")=");
                        ZeroText(a1);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("x²")) {
                        double a1 = Double.parseDouble(MainPanel.result);
                        double s = a1 * a1;
                        ShowsPanel.display1.setText(MainPanel.result + "²" + "=");
                        ZeroText(s);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("1/x")) {
                        // 倒数运算
                        double a1 = Double.parseDouble(MainPanel.result);
                        if (a1 == 0.0) {
                            // 操作不合法
                            ShowsPanel.display2.setText("零没有倒数");
                        } else {
                            a1 = 1 / a1;
                            ShowsPanel.display1.setText("1" + "/" + MainPanel.result + "=");
                            ZeroText(a1);
                            MainPanel.result = a1 + "";
                        }
                    } else if (MainPanel.lastcommand.equals("+")) {
                        double a1 = Double.parseDouble(MainPanel.result);
                        double a2 = Double.parseDouble(ShowsPanel.display2.getText());
                        double s = a1 + a2;
                        if (MainPanel.result == "0.") {//去除0.问题
                            if (ShowsPanel.display2.getText() == "0.")
                                ShowsPanel.display1.setText(0 + "+" + 0 + "=");
                            else ShowsPanel.display1.setText(0 + "+" + ShowsPanel.display2.getText() + "=");
                        } else if (ShowsPanel.display2.getText() == "0.") {
                            ShowsPanel.display1.setText(MainPanel.result + "+" + 0 + "=");
                        } else
                            ShowsPanel.display1.setText(MainPanel.result + "+" + ShowsPanel.display2.getText() + "=");
                        ZeroText(s);
                        MainPanel.result = s + "";
                    } else if (MainPanel.lastcommand.equals("-")) {
                        double a1 = Double.parseDouble(MainPanel.result);
                        double a2 = Double.parseDouble(ShowsPanel.display2.getText());
                        double s = a1 - a2;
                        if (MainPanel.result == "0.") {//去除0.问题
                            if (ShowsPanel.display2.getText() == "0.")
                                ShowsPanel.display1.setText(0 + "-" + 0 + "=");
                            else ShowsPanel.display1.setText(0 + "-" + ShowsPanel.display2.getText() + "=");
                        } else if (ShowsPanel.display2.getText() == "0.") {
                            ShowsPanel.display1.setText(MainPanel.result + "-" + 0 + "=");
                        } else
                            ShowsPanel.display1.setText(MainPanel.result + "-" + ShowsPanel.display2.getText() + "=");
                        ZeroText(s);
                        MainPanel.result = s + "";
                    } else if (MainPanel.lastcommand.equals("×")) {
                        double a1 = Double.parseDouble(MainPanel.result);
                        double a2 = Double.parseDouble(ShowsPanel.display2.getText());
                        double s = a1 * a2;
                        if (MainPanel.result == "0.") {//去除0.问题
                            if (ShowsPanel.display2.getText() == "0.")
                                ShowsPanel.display1.setText(0 + "×" + 0 + "=");
                            else ShowsPanel.display1.setText(0 + "×" + ShowsPanel.display2.getText() + "=");
                        } else if (ShowsPanel.display2.getText() == "0.") {
                            ShowsPanel.display1.setText(MainPanel.result + "×" + 0 + "=");
                        } else
                            ShowsPanel.display1.setText(MainPanel.result + "×" + ShowsPanel.display2.getText() + "=");
                        ZeroText(s);
                        MainPanel.result = s + "";
                    } else if (MainPanel.lastcommand.equals("÷")) {
                        // 除法运算
                        // 如果当前结果文本框中的值等于0
                        double a1 = Double.parseDouble(MainPanel.result);
                        double a2 = Double.parseDouble(ShowsPanel.display2.getText());
                        if (a2 == 0.0) {
                            // 操作不合法
                            ShowsPanel.display2.setText("除数不能为零");
                        } else {
                            double s = a1 / a2;
                            if (MainPanel.result == "0.")//去除0.问题
                                ShowsPanel.display1.setText(0 + "÷" + ShowsPanel.display2.getText() + "=");
                            else
                                ShowsPanel.display1.setText(MainPanel.result + "÷" + ShowsPanel.display2.getText() + "=");
                            ZeroText(s);
                            MainPanel.result = s + "";
                        }
                    } else if (MainPanel.lastcommand.equals("sin")) {//sin运算
                        double π = Math.PI;
                        double a1 = Double.parseDouble(MainPanel.result);
                        double s = Math.sin(a1);
                        ShowsPanel.display1.setText("sin(" + a1 + ") =");
                        ZeroText(s);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("cos")) {//cos运算
                        double π = Math.PI;
                        double a1 = Double.parseDouble(MainPanel.result);
                        double s = Math.cos(a1);
                        ShowsPanel.display1.setText("cos(" + a1 + ") =");
                        ZeroText(s);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("tan")) {//tan运算
                        double π = Math.PI;
                        double a1 = Double.parseDouble(MainPanel.result);
                        double s = Math.tan(a1);
                        ShowsPanel.display1.setText("tan(" + a1 + ") =");
                        ZeroText(s);
                        MainPanel.result = a1 + "";
                    } else if (MainPanel.lastcommand.equals("n!")) {//阶乘运算
                        int i, sum = 1, s;
                        double a1 = Double.parseDouble(MainPanel.result);
                        for (i = 1; i <= a1; i++) {
                            sum = sum * i;
                        }
                        s = sum;
                        ShowsPanel.display1.setText(a1 + "! =");
                        ZeroText(s);
                        MainPanel.result = a1 + "";
                    }
                }
                MainPanel.lastcommand = e.getActionCommand();//获取当前的运算符
                MainPanel.firstDigit = true;
            }
        }
    }

    public void ZeroText(double s) {
        long t1;
        double t2;
        t1 = (long) s;
        t2 = s - t1;
        if (t2 == 0) {
            ShowsPanel.display2.setText(String.valueOf(t1));
        } else {
            ShowsPanel.display2.setText(String.valueOf(s));
        }
    }
}


