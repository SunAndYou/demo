package 图形化界面.链接数据库;
import java.sql.*;
import java.util.Scanner;
public class 修改 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/q";
            String username = "root";
            String passwords = "sang1416490901";
            conn = DriverManager.getConnection(url, username, passwords);
            //conn = DriverManager.getConnection("jdbc:mysql:///q","root","sang1416490901");

            // String sql="update u set name="+Name+",password="+Password+",email="+Email+",birthday="+Birthday+" where name="+NAME;
            // String sql="update u set name=?,password=?,email=?,birthday=? where id="+ID;
            String sql="update u set name=?,password=?,email=?,birthday=? ";

            Scanner scan = new Scanner(System.in);

            System.out.println("a:ID查找");
            System.out.println("b:姓名查找");
            System.out.println("c:账号查找");
            System.out.println("d:邮箱查找");
            System.out.println("e:生日查找");
            System.out.println("请输入要通过什么方式查找要修改的同学：");
            String i=scan.next();

            switch(i){
                case "a":System.out.println("请输入要查询同学的ID：");String ID=scan.next();sql +="where id = "+ID;break;
                case "b":System.out.println("请输入要查询同学的姓名：");String NAME=scan.next();sql +="where name = '"+NAME+"'";break;
                case "c":System.out.println("请输入要查询同学的账号：");String PASSWORD=scan.next();sql +="where pasword = '"+PASSWORD+"'";break;
                case "d":System.out.println("请输入要查询同学的邮箱：");String EMAIL=scan.next();sql +="where email = '"+EMAIL+"'";break;
                case "e":System.out.println("请输入要查询同学的生日：");String BIRTNDAY=scan.next();sql +="where biathday = '"+BIRTNDAY+"'";break;
            }

            System.out.println("请输入修改信息：");
            System.out.println("请输入名字：");
            String Name=scan.next();
            System.out.println("请输入账号：");
            String Password=scan.next();
            System.out.println("请输入邮箱：");
            String Email=scan.next();
            System.out.println("请输入生日：");
            String Birthday=scan.next();


            ps=conn.prepareStatement(sql);
            ps.setString(1, Name);
            ps.setString(2, Password);
            ps.setString(3, Email);
            ps.setString(4, Birthday);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


        finally {

            if (rs!= null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (ps!= null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ps = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
