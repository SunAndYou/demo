package study_end;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentJDialogUpdate extends JDialog {
    int i=0,j=0;
    int count=0;
    int selectedRow;
    int selectColumn;
    String selected;
    String selectednum;
    public StudentJDialogUpdate(JFrame jframe){
        super(jframe,"修改",true);
        setBounds(200, 200, 400, 400);
        Container c =getContentPane();
        c.setLayout(null);
        String columnNames[] = new String[]{"学号","姓名","成绩","学科"};
        String tableValues[][] =new String[100][3];
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
            Statement s = connection.createStatement();
        )
        {
            String sql = "select num from Grade";
            String sql1 = "select name from Grade";
            String sql2 = "select grade from Grade";
            String sql3 = "select course from Grade";
            String sql4 = "select count(num) from Grade";
            ResultSet rs =s.executeQuery(sql);
            while(rs.next()) {
                tableValues[i][0] = rs.getString("num");
                i++;
            }
            i=0;
            ResultSet rs1 =s.executeQuery(sql1);
            while(rs1.next()) {

                tableValues[i][1] = rs1.getString("name");
                i++;
            }
            i=0;
            ResultSet rs2 =s.executeQuery(sql2);
            while(rs2.next()) {
                tableValues[i][2] = rs2.getString("grade");
                i++;
            }
            i=0;
            ResultSet rs3 =s.executeQuery(sql3);
            while(rs3.next()) {

                tableValues[i][1] = rs3.getString("course");
                i++;
            }
            ResultSet rs4=s.executeQuery(sql4);
            while(rs4.next()) {
                count = rs4.getInt("count(num)");
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }
        String newtableValues[][] = new String[count+1][3];
        for(i=0 ;i<count+1 ;i++) {
            for(j=0; j<3 ;j++) {

                newtableValues[i][j] = tableValues[i][j];
            }
        }
        DefaultTableModel tablemodel = new DefaultTableModel(newtableValues,columnNames);
        JTable table = new JTable(tablemodel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane js = new JScrollPane(table);
        JButton b = new JButton("保存");
        b.setBounds(150, 200, 60, 30);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRow = table.getSelectedRow();
                selectColumn = table.getSelectedColumn();
                table.getCellEditor(selectedRow,selectColumn).stopCellEditing();
                selected = (String)table.getValueAt(selectedRow, selectColumn);
                selectednum = (String)table.getValueAt(selectedRow, 0);
                System.out.println(selected);
                System.out.println(selectednum);
                String sql1 = "update Grade set num='"+selected+"' where num ='"+selectednum+"'";
                String sql2 = "update Grade set name='"+selected+"' where num ='"+selectednum+"'";
                String sql3 = "update Grade set grade='"+selected+"' where num ='"+selectednum+"'";
                String sql4 = "update Grade set course='"+selected+"' where num ='"+selectednum+"'";
                try {
                    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
                    if(selectColumn==0) {
                        //System.out.println("123");
                        PreparedStatement ps =  c1.prepareStatement(sql1);
                        ps.execute();
                    }
                    if(selectColumn==1) {
                        //System.out.println("456");
                        PreparedStatement ps =  c1.prepareStatement(sql2);
                        ps.execute();
                    }
                    if(selectColumn==2) {
                        //System.out.println("789");
                        PreparedStatement ps =  c1.prepareStatement(sql3);
                        ps.execute();
                    }
                    if(selectColumn==3) {
                        //System.out.println("101112");
                        PreparedStatement ps =  c1.prepareStatement(sql4);
                        ps.execute();
                    }
                    System.out.println("修改数据成功");
                } catch (SQLException e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        });
        c.add(b);
        js.setVisible(true);
        c.add(js);

        js.setBounds(0, 0, 400, 400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    }
}