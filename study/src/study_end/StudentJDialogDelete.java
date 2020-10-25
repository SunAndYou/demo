package study_end;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
public class StudentJDialogDelete extends JDialog{
    int i=0,j=0;
    int count=0;
    int selectedRow;
    String selected;
    public StudentJDialogDelete(JFrame jframe) {
        super(jframe,"删除",true);
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
                tableValues[i][3] = rs3.getString("course");
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

        JButton b1= new JButton("删除");
        JButton b2= new JButton("保存");
        b1.setBounds(110, 200, 60, 30);
        b2.setBounds(180, 200, 60, 30);
        c.add(b1);
        c.add(b2);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedRow = table.getSelectedRow();

                if(selectedRow!=-1) {
                    selected = (String) table.getValueAt(selectedRow, 0);
                    tablemodel.removeRow(selectedRow);

                }
            }
        });
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sql4 = "delete from Grade where num=?";
                try {
                    Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost/student","root","root");
                    PreparedStatement ps =  c1.prepareStatement(sql4);
                    ps.setString(1, selected);
                    ps.execute();
                    System.out.println("删除数据成功");
                } catch (SQLException e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        });
        js.setVisible(true);
        c.add(js);
        js.setBounds(0, 0, 400, 400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
    }
}