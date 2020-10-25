package 图形化界面.链接数据库;
import java.sql.*;
import java.util.Scanner;
public class 插入 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement  preStmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/q";
            String username = "root";
            String passwords = "sang1416490901";

            conn = DriverManager.getConnection(url, username, passwords);

            Scanner scan = new Scanner(System.in);
            System.out.println("请输入名字：");
            String name=scan.next();
            System.out.println("请输入账号：");
            String password=scan.next();
            System.out.println("请输入邮箱：");
            String email=scan.next();
            System.out.println("请输入生日：");
            String birthday=scan.next();

            String sql = "INSERT INTO u(name,password,email,birthday)"
                    + "VALUES(?,?,?,?)";

            preStmt = conn.prepareStatement(sql);


            preStmt.setString(1, name);
            preStmt.setString(2, password);
            preStmt.setString(3, email);
            preStmt.setString(4, birthday);

        /*   preStmt.setString(1, "宁");
            preStmt.setString(2, "123456");
            preStmt.setString(3, "1055575706@qq.com");
            preStmt.setString(4, "1999-07-08");
         */

            preStmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preStmt != null) {
                try {
                    preStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                preStmt = null;
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
