package Back;
//import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

public class User {
	Scanner sc = new Scanner(System.in);
	public Connection createCon() throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/tickets";
		String uname = "root";
		String pass="$riNamu89";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	@SuppressWarnings("resource")
	public boolean register(String userName, String password, String userType, String setype, String email) throws Exception
	{
		boolean reg = false;
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from user WHERE username=\""+userName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		if(!rs.getBoolean(1))
		{
			ResultSet rs1;
			UUID uniqueKey;
			do
			{
				uniqueKey = UUID.randomUUID();
				String query2 = "SELECT EXISTS(SELECT * from user WHERE sysid=\""+uniqueKey.toString()+"\")";
				rs1 = st.executeQuery(query2);
				rs1.next();
			}while(rs1.getBoolean(1));
			if(!rs1.getBoolean(1))
			{
				String query = "insert into user values(?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, uniqueKey.toString());
				ps.setString(2,userName);
				ps.setString(3, password);
				ps.setString(4, userType);
				ps.setString(8, email);
				if(userType=="Admin")
				{
					
					ps.setBoolean(5, false);
					ps.setBoolean(6,true);
					ps.setString(7, null);
					ps.executeUpdate();
					reg=true;
				}
				else if(userType=="EndUser")
				{
					ps.setBoolean(5, false);
					ps.setBoolean(6,true);
					ps.setString(7, null);
					ps.executeUpdate();
					reg=true;
				}
				else if(userType=="ServiceEngineer")
				{
					ps.setBoolean(5, false);
					ps.setBoolean(6,true);
					ps.setString(7,setype);
					ps.executeUpdate();
					reg=true;
				}
				ps.close();
			}
			
		}
		else
		{
			reg=false;
		}
		st.close();
		return reg;
	}
	public String login(String userName, String password) throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from user WHERE username=\""+userName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		if(rs.getBoolean(1))
		{
			query1 = "SELECT * from user WHERE username=\""+userName+"\"";
			rs = st.executeQuery(query1);
			rs.next();
			if(rs.getString(3).equals(password))
			{
				String query2 = "update user set userstatus = 1 where username=?";
				PreparedStatement ps = con.prepareStatement(query2);
				ps.setString(1, userName);
				ps.executeUpdate();
				return rs.getString(4);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	public void logout(String userName) throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from user WHERE username=\""+userName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		if(rs.getBoolean(1))
		{
			query1 = "SELECT * from user WHERE username=\""+userName+"\"";
			rs = st.executeQuery(query1);
			rs.next();
			String query2 = "update user set userstatus = 0 where username=?";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1, userName);
			ps.executeUpdate();
			
		}
	}
	public String forgotPassword(String userName) throws Exception {
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from user WHERE username=\""+userName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		String pass = "";
		if(rs.getBoolean(1))
		{
			query1 = "SELECT password from user WHERE username=\""+userName+"\"";
			rs = st.executeQuery(query1);
			rs.next();
			pass = rs.getString(1);
			String query2 = "SELECT email from user WHERE username=\""+userName+"\"";
			ResultSet rs2 = st.executeQuery(query2);
			rs2.next();
			String recipient = rs2.getString(1);
		    String sender = "parinitha.p89@gmail.com";
		    String host = "smtp.planonsoftware.com";		      
		    Properties properties = System.getProperties();
		    properties.put("mail.smtp.host", host);
		    Session session = Session.getDefaultInstance(properties);
		    try
		    {
		         MimeMessage message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(sender));
		         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		         message.setSubject("Reset Password");
		         message.setText("The password is:"+pass+" for "+userName);
		         Transport.send(message);
		         System.out.println("Mail successfully sent");
		      }
		      catch (MessagingException mex) 
		      {
		         mex.printStackTrace();
		      }
		}
		return pass;
	}
	
}