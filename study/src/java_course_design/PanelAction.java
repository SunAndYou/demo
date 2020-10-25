package java_course_design;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelAction implements ActionListener {//数字键按钮事件

    public void actionPerformed(ActionEvent e) {
        if (MainPanel.start == true) {
            //清空文本
            ShowsPanel.display1.setText("");
            ShowsPanel.display2.setText("");
            MainPanel.start = false;
        }
        if ("0123456789.".indexOf(e.getActionCommand()) >= 0) {
            if (MainPanel.firstDigit) {
                // 输入的第一个数字
                if (e.getActionCommand().equals(".")) {//如果第一个是“.”
                    ShowsPanel.display2.setText("0.");
                } else if (e.getActionCommand().equals("0")) {//如果第一个是“0”
                    ShowsPanel.display2.setText("0");
                    MainPanel.firstDigit = true;
                    return;
                } else ShowsPanel.display2.setText(e.getActionCommand());
            } else if ((e.getActionCommand().equals(".")) && (ShowsPanel.display2.getText().indexOf(".") < 0)) {
                // 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
                ShowsPanel.display2.setText(ShowsPanel.display2.getText() + ".");
            } else //if(Double.parseDouble(ShowPanel.display2.getText())!=0)
                if (!e.getActionCommand().equals(".")) {
                    // 如果输入的不是小数点，则将数字附在结果文本框的后面
                    ShowsPanel.display2.setText(ShowsPanel.display2.getText() + e.getActionCommand());
                }
            // 以后输入的肯定不是第一个数字了
            MainPanel.firstDigit = false;
        }
    }

}