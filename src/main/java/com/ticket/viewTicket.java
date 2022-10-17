package com.ticket;
import Back.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class viewTicket
 */
@WebServlet("/viewTicket")
public class viewTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	class SortbyrollTick implements Comparator<List<String>>
	{
	    public int compare(List<String> a, List<String> b)
	    {
	    	if(a.get(0).compareTo(b.get(0))==0)
	    	{
	    		if(a.get(2)!=null && b.get(2)!=null) return a.get(2).compareTo(b.get(2));
	    		else return 0;
	    	}
	    	else return (a.get(0).compareTo(b.get(0)));
	    }
	}
    public viewTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String uname = s.getAttribute("username").toString();
		String utype = s.getAttribute("usertype").toString();
		if(utype.equalsIgnoreCase("enduser"))
		{
			EndUser A = new EndUser();
			try {
				ResultSet rs = A.viewTickets(uname);
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> ticket = new ArrayList<>();
					ticket.add(rs.getString(1));
					ticket.add(rs.getString(2));
					ticket.add(rs.getString(3));
					String se = rs.getString(5);
					if(se==null)
					{
						ticket.add("not assigned");
					}
					else
					{
						ticket.add(se);
					}
					ticket.add(rs.getString(6));
					ticket.add(rs.getString(7));
					if(rs.getTimestamp(8)!=null) ticket.add(rs.getTimestamp(8).toString());
					lists.add(ticket);
				}
				Collections.sort(lists, new SortbyrollTick());
				Collections.reverse(lists);
				request.setAttribute("Ticket", lists);
				RequestDispatcher rd = request.getRequestDispatcher("viewticketEU.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(utype.equalsIgnoreCase("serviceengineer"))
		{
			ServiceEngineer A = new ServiceEngineer();
			try {
				ResultSet rs = A.viewTickets(uname);
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> ticket = new ArrayList<>();
					int tid = rs.getInt(1);
					ticket.add(Integer.toString(tid));
					ticket.add(rs.getString(2));
					ticket.add(rs.getString(3));
					ticket.add(rs.getString(4));
					String st = rs.getString(6);
					ticket.add(st);
					ticket.add(rs.getString(7));
					if(rs.getTimestamp(8)!=null) ticket.add(rs.getTimestamp(8).toString());
					lists.add(ticket);
				}
				Collections.sort(lists, new SortbyrollTick());
				Collections.reverse(lists);
				if(lists.isEmpty())
				{
					request.setAttribute("userty", utype);
					RequestDispatcher rd = request.getRequestDispatcher("viewticketNo.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Ticket", lists);
					RequestDispatcher rd = request.getRequestDispatcher("viewticketSE.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(utype.equalsIgnoreCase("admin"))
		{
			Admin A = new Admin();
			try {
				ResultSet rs = A.viewTickets();
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> ticket = new ArrayList<>();
					ticket.add(rs.getString(1));
					ticket.add(rs.getString(2));
					ticket.add(rs.getString(3));
					ticket.add(rs.getString(4));
					String se = rs.getString(5);
					if(se==null)
					{
						ticket.add("not assigned");
					}
					else
					{
						ticket.add(se);
					}
					String status = rs.getString(6);
					ticket.add(status);
					ticket.add(rs.getString(7));
					if(rs.getTimestamp(8)!=null) ticket.add(rs.getTimestamp(8).toString());
					lists.add(ticket);
				}
				Collections.sort(lists, new SortbyrollTick());
				Collections.reverse(lists);
				request.setAttribute("Ticket", lists);
				RequestDispatcher rd = request.getRequestDispatcher("viewTicketAD.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
