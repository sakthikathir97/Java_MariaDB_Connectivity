import java.sql.*;


public class Sql1 
{
	public static void main(String args[])throws ClassNotFoundException ,SQLException 
	{
		String classDriver="org.mariadb.jdbc.Driver";
		Connection conn;
		String Driver="jdbc:mariadb://localhost:3306/Student";
		String uname="root";
		String pword=null;
		Statement st;
		try
		{	
		
		Class.forName(classDriver);
		conn=DriverManager.getConnection(Driver,uname,pword);
		st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from Section");
		
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		
		String ins1="insert into Section values(?,?)";
		PreparedStatement ps1=conn.prepareStatement(ins1);
		ps1.setInt(1, 104);
		ps1.setString(2,"hamshika");
		int res=ps1.executeUpdate();
		System.out.println("record insert successfully :"+res);
		
		String up1=("update Section set name=? where id=?");
		PreparedStatement ps2=conn.prepareStatement(up1);
		ps2.setString(1, "murugan");
		ps2.setInt(2,101);
		int res2=ps2.executeUpdate();
		System.out.println("record update successfully :"+res2);
		
		String dt1=("delete from Section where id=?");
		PreparedStatement ps3=conn.prepareStatement(dt1);
		ps3.setInt(1,104);
		int res3=ps3.executeUpdate();
		System.out.println("delete record successfully :"+res3);
		
		st.close();
		rs.close();
		conn.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

