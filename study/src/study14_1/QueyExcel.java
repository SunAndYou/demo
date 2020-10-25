package study14_1;
import java.sql.*;
public class QueyExcel {
	public static void main(String args[]) { 
	      try{
	      	Class.forName("sun.jdbc.odbc.JdbcOdbcDrive");
		  }catch (ClassNotFoundException e){
			  System.out.print(e);
		  }
	      Connection con;
	      Statement sql; 
	      ResultSet rs;
	      try { 
	           con=DriverManager.getConnection("jdbc:mysql:///shop","root","1223405467");
	           
	           sql=con.createStatement();
	           rs=sql.executeQuery("select * from goods");
	           System.out.println("name   | price | inventory  | producer");
	           while(rs.next()) {
	        	   String name = rs.getString("name");
	        	   int price = rs.getInt("price");
	        	   int inventory = rs.getInt("inventory");
	               String producer = rs.getString("producer");
	               System.out.println( name + "    |    " + price + "    |    " + inventory + "    |    " + producer);
	           }
	       }
	       catch(SQLException e) {
	           System.out.println(""+e);
	       }
	   }    

}
