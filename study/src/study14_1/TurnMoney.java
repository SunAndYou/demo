package study14_1;
import java.sql.*;
public class TurnMoney {
	public static void main(String args[]){
	       Connection con = null;
	       Statement sql; 
	       ResultSet rs;
	       try{ double n = 100;
	            con = DriverManager.getConnection("jdbc:mysql:///shop","root","1223405467");
	            con.setAutoCommit(false);
	            sql = con.createStatement();
	            rs = sql.executeQuery("SELECT * FROM card1 WHERE number='zhangsan'");
	            rs.next();
	            double amountOne = rs.getDouble("amount");
	            System.out.println("ת�˲���֮ǰzhangsan��Ǯ������:"+amountOne); 
	            rs = sql.executeQuery("SELECT * FROM card2 WHERE number='xidanShop'");
	            rs.next();
	            double amountTwo = rs.getDouble("amount");
	            System.out.println("ת�˲���֮ǰxidanShop��Ǯ������:"+amountTwo);
	            amountOne = amountOne-n;
	            amountTwo = amountTwo+n; 
	            sql.executeUpdate(
	"UPDATE card1 SET amount ="+amountOne+" WHERE number ='zhangsan'");
	            sql.executeUpdate(
	"UPDATE card2 SET amount ="+amountTwo+" WHERE number ='xidanShop'");
	            con.commit(); //��ʼ������,��������쳣ֱ��ִ��catch��
	            con.setAutoCommit(true);//�ָ��Զ��ύģʽ
	            rs = sql.executeQuery("SELECT * FROM card1 WHERE number='zhangsan'");
	            rs.next();
	            amountOne = rs.getDouble("amount");
	            System.out.println("ת�˲���֮��zhangsan��Ǯ������:"+amountOne); 
	            rs = sql.executeQuery("SELECT * FROM card2 WHERE number='xidanShop'");
	            rs.next();
	            amountTwo = rs.getDouble("amount");
	            System.out.println("ת�˲���֮��xidanShop��Ǯ������:"+amountTwo);
	            con.close();
	         }
	         catch(SQLException e){
	            try{ con.rollback();//�������������Ĳ���
	            }
	            catch(SQLException exp){}
	            System.out.println(e.toString());
	         }
	    }

}
