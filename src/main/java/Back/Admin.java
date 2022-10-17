package Back;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Admin extends User{
	public boolean addAdmin(String Username, String Password, String em) throws Exception
	{
		return super.register(Username, Password,"Admin",null,em);
	}
	public boolean addEndUser(String Username, String Password,String em) throws Exception
	{
		return super.register(Username, Password,"EndUser",null,em);
	}
	public boolean addServiceEngineer(String Username, String Password, String setype,String em) throws Exception
	{
		return super.register(Username, Password,"ServiceEngineer",setype,em);
	}
	public ResultSet viewUsers() throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT * from user";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet viewTickets() throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT * from ticket";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet filterTicket(String tickT) throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT * from ticket where tickettype=\""+tickT+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet filterUser(String UserT) throws Exception
	{
		Connection con = createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT * from user where usertype=\""+UserT+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
}
