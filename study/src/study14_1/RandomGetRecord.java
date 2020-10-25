package study14_1;
import java.sql.*;
import java.util.*;
public class RandomGetRecord {
	public static void main(String args[]){ 
	      int wantRecordAmount = 5;
	      Random random =new Random();
	      Connection con;
	      Statement sql; 
	      ResultSet rs;
	      try{  
	    
	           String uri="jdbc:mysql://localhost:3306/shop"; 
	           String id="root";
	           String password="sang1416490901";
	           con=DriverManager.getConnection(uri,id,password);
	           sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	        		   ResultSet.CONCUR_READ_ONLY);
	           rs =sql.executeQuery("SELECT * FROM goods"); //sql����.executeQuery������ѯgoods���е�ȫ����¼
	           rs.last();                                       //��rs���α��Ƶ�rs�����һ��
	           int count=rs.getRow();  
	           Vector<Integer> vector=new Vector<Integer>();
	           for(int i=1;i<=count;i++) {
	               vector.add(new Integer(i));
	           }
	           int itemAmount=Math.min(wantRecordAmount,count);
	           System.out.println("�����ȡ"+itemAmount+"����¼.");
	           double sum =0, n = itemAmount;
	           while(itemAmount>0) {
	              int randomIndex = random.nextInt(vector.size());
	              int index=(vector.elementAt(randomIndex)).intValue();
	              rs.absolute(index);//��rs���α��α��Ƶ�index
	              int id1=rs.getInt(1);
	              String number = rs.getString(2);
	              String name = rs.getString(3); 
	              //java.util.Date date=rs.getDate(3);
	              double score=rs.getDouble(4);
	              System.out.println("---"+score);
	              sum = sum+score;
	              itemAmount--; 
	              vector.removeElementAt(randomIndex); 
	            }
	            con.close();
	            double aver = sum/n;
	            System.out.println("ƽ����:"+aver);
	       }
	       catch(SQLException e) {
	           System.out.println(""+e);
	       }
	   }    
}
