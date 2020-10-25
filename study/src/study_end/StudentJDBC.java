package study_end;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentJDBC implements StudentDAO {
    public StudentJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        System.out.println("数据库连接成功");
        return DriverManager.getConnection("jdbc:mysql://localhost/grade", "root", "1223405467");
    }

    public void add(Student student) {
        String sql = "insert into Grade values(?,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, student.num);
            ps.setString(2, student.name);
            ps.setInt(3, student.grade);
            ps.setString(4, student.course);
            ps.execute();
            System.out.println("数据添加成功");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public void update(Student student) {
        // TODO Auto-generated method stub

    }

    @Override
    public void select(Student student) {

    }

}
