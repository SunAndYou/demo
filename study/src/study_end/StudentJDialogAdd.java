package study_end;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentJDialogAdd extends JDialog {
    public static int  rowCount=0;
    public int columnCount = 4;;//设置初始行与列
    String num[] = new String[100];
    String name[] = new String[100];
    String grade[] = new String[100];
    String course[] = new String[100];
    public String[][] newtableValues = new String[100][4];
    public StudentJDialogAdd(JFrame jframe) {
        /*
         * 设置简单的窗口格式
         */
        super(jframe,"增加",true);
        setBounds(200, 200, 400, 400);
        Container c =getContentPane();
        c.setLayout(null);
        /*
         * 设置表格内容
         */
        String columnNames[] = new String[]{"学号","姓名","成绩","学科"};
        String tableValues[][] = new String[0][4];
        DefaultTableModel tablemodel = new DefaultTableModel(tableValues,columnNames);
        JTable table = new JTable(tablemodel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JButton b= new JButton("增加");
        JButton b1= new JButton("删除");
        JButton b2= new JButton("保存");
        b.setBounds(100, 200, 60, 30);
        b1.setBounds(170, 200, 60, 30);
        b2.setBounds(240, 200, 60, 30);
        c.add(b);
        c.add(b1);
        c.add(b2);
        JScrollPane js = new JScrollPane(table);
        b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                js.setVisible(true);
                String []newdata = {""};
                tablemodel.addRow(newdata);
                rowCount++;
            }
        });
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow!=-1) {
                    tablemodel.removeRow(selectedRow);
                    rowCount--;
                }
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String newtableValues[][] = new String[rowCount][4];
                for(int i=0; i<table.getRowCount(); i++) {

                    for(int j=0; j<table.getColumnCount();j++) {
                        /*
                         * 解决JTable保存时最后输入的一个单元格(cell)数据丢失问题的方法
                         *
                         */
                        table.getCellEditor(rowCount-1, 1).stopCellEditing();
                        table.getCellEditor(rowCount, 1).stopCellEditing();
                        if(j == 0) {
                            num[i] = (String)table.getValueAt(i,j);
                        }
                        if(j == 1) {
                            name[i] = (String)table.getValueAt(i,j);
                        }
                        if(j == 2) {
                            grade[i] = (String) table.getValueAt(i,j);
                        }
                        if(j == 3) {
                            course[i] = (String)table.getValueAt(i,j);
                        }
                        newtableValues[i][j] = (String)table.getValueAt(i,j);
                    }
                }
                for(int k=0 ;k<rowCount; k++) {
                    StudentJDBC s = new StudentJDBC();
                    Student student = new Student(Integer.parseInt(num[k]),name[k],Integer.parseInt(grade[k]),course[k]);
                    s.add(student);
                }
            }
        });
        js.setVisible(true);
        c.add(js);
        js.setBounds(0, 0, 400, 400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    }
    public int getRowCount() {
        return rowCount;
    }
}