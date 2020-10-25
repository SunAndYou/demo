package 图形化界面.链接数据库;
import java.sql.*;
import java.util.Scanner;
public class 查找1 {
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


            Scanner scan = new Scanner(System.in);
            System.out.println("请输入要查找同学的名字：");
            String NAME=scan.next();

            String sql = "select * from u where name = '"+NAME+"'";



              stmt = conn.createStatement();
              rs = stmt.executeQuery(sql);

            System.out.println("id | name   | password | email  | birthday");
            if(rs.next()) {//如果查询到了
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");
                String email = rs.getString("email");
                Date birthday = rs.getDate("birthday");
                System.out.println(id + " | " + name + " | " + psw + " | " + email + " | " + birthday);

            }

            /*
            Statement st =conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = st.executeQuery(sql);

            System.out.print("第三条数据的name值为:");
            rs.absolute(3);
            System.out.println(rs.getString("name"));
            System.out.print("第一条数据的name值为:");
            rs.beforeFirst();
            rs.next();
            System.out.println(rs.getString("name"));
            System.out.print("最后一条数据的name值为:");
            rs.afterLast();
            rs.previous();
            System.out.println(rs.getString("name"));
             */

        }

        catch (Exception e) {
            e.printStackTrace();
        } finally {
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
