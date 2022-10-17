package Back;
import java.sql.*;
import java.util.Calendar;

public class EndUser extends User{
	public ResultSet viewTickets(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where enduser=\""+userName+"\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public ResultSet viewTicketsC(String userName) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		String query1 = "select * from ticket where enduser=\""+userName+"\" and ticketstatus!=\"close\"";
		ResultSet rs = st.executeQuery(query1);
		return rs;
	}
	public void closeTicket(int ticketName) throws Exception
	{
		User u = new User();
		Connection con = u.createCon();
		Statement st = con.createStatement();
		String query1 = "SELECT EXISTS(SELECT * from ticket WHERE ticketid=\""+ticketName+"\")";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		if(rs.getBoolean(1))
		{
			query1 = "select * from ticket where ticketid=\""+ticketName+"\"";
			rs = st.executeQuery(query1);
			rs.next();
			String query2 = "update ticket set ticketstatus=? where ticketid=?";
			PreparedStatement ps = con.prepareStatement(query2);
			ps.setString(1, "close");
			ps.setInt(2,ticketName);
			ps.executeUpdate();
			String seName = rs.getString(4);
			String query3 = "SELECT EXISTS(SELECT * from user WHERE username=\""+seName+"\")";
			ResultSet rs1 = st.executeQuery(query3);
			rs1.next();
			if(rs1.getBoolean(1))
			{
				query3="update user set availabilty=1 where username=?";
				PreparedStatement ps1 = con.prepareStatement(query3);
				ps1.setString(1,seName);
				ps1.executeUpdate();
			}
		}
	}
	public int raiseTicket(String userName,String ticketName, String ticketType, String ticketDes) throws Exception
	{
		Connection con = super.createCon();
		Statement st = con.createStatement();
		ResultSet rs;
		String query = "select Max(ticketid) from ticket";
		rs = st.executeQuery(query);
		rs.next();
		int i=2;
		int j = rs.getInt(1);
		String query2 = "SELECT EXISTS(SELECT * from user WHERE setype=\""+ticketType+"\")";
		rs = st.executeQuery(query2);
		rs.next();
		String query3 = "insert into ticket values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query3);
		ps.setInt(1, j+1);
		ps.setString(2, ticketName);
		ps.setString(3, ticketType);
		ps.setString(4, userName);
		ps.setString(7, ticketDes);
		long timeNow = Calendar.getInstance().getTimeInMillis();
		java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
		ps.setTimestamp(8, ts);
		if(rs.getBoolean(1))
		{
			query2 = "select * from user where setype=\""+ticketType+"\"";
			rs = st.executeQuery(query2);
			boolean availability = false;
			while(rs.next())
			{
				if(rs.getBoolean(6))
				{
					availability = true;
					ps.setString(5,rs.getString(2));
					ps.setString(6, "open");
					i=1;
					String query4 = "update user set availabilty = 0 where username = ?";
					PreparedStatement ps2 = con.prepareStatement(query4);
					ps2.setString(1, rs.getString(2));
					ps2.executeUpdate();
					break;
				}
			}
			if(!availability)
			{
				ps.setString(5, null);
				ps.setString(6, "not assigned");
				i=2;
			}
		}
		else
		{
			ps.setString(5, null);
			ps.setString(6, "not assigned");
			i=2;
		}
		ps.executeUpdate();
		return i;
	}
}
