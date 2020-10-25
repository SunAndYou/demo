package 图形化界面.链接数据库.ssp_calculators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InsertAction implements ActionListener{//数字键按钮事件
    @Override

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(CalcultorPanel.start==true) {
            //清空文本
            ShowPanel.display1.setText("");
            ShowPanel.display2.setText("");
            CalcultorPanel.start=false;
        }
        if ("0123456789.".indexOf(e.getActionCommand()) >= 0) {
            if (CalcultorPanel.firstDigit) {
                // 输入的第一个数字
                if(e.getActionCommand().equals(".")) {//如果第一个是“.”
                    ShowPanel.display2.setText("0.");
                }else if(e.getActionCommand().equals("0")) {//如果第一个是“0”
                    ShowPanel.display2.setText("0");
                    CalcultorPanel.firstDigit=true;
                    return;
                }
                else ShowPanel.display2.setText(e.getActionCommand());
            }
            else if ((e.getActionCommand().equals(".")) && (ShowPanel.display2.getText().indexOf(".") < 0)) {
                // 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
                ShowPanel.display2.setText(ShowPanel.display2.getText() + ".");
            }
            else //if(Double.parseDouble(ShowPanel.display2.getText())!=0)
                if (!e.getActionCommand().equals(".")) {
                    // 如果输入的不是小数点，则将数字附在结果文本框的后面
                    ShowPanel.display2.setText(ShowPanel.display2.getText() + e.getActionCommand());
                }
            // 以后输入的肯定不是第一个数字了
            CalcultorPanel.firstDigit = false;
        }
    }

}
