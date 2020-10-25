package 图形化界面.链接数据库;
import java.sql.*;
public class 查询 {
    public static void main(String[] args) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/q";
            String username = "root";
            String password = "sang1416490901";
            conn = DriverManager.getConnection(url, username, password);
            //conn = DriverManager.getConnection("jdbc:mysql:///q","root","sang1416490901");

            stmt = conn.createStatement();

            String sql = "select * from u";
            rs = stmt.executeQuery(sql);

            System.out.println("id | name   | password | email  | birthday");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.println(id + " | " + name + " | " + psw + " | "
                        + email + " | " + birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
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
