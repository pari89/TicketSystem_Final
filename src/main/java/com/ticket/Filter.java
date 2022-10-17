package com.ticket;

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
import Back.Admin;

/**
 * Servlet implementation class Filter
 */
@WebServlet("/Filter")
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	class Sortbyroll implements Comparator<List<String>>
	{
	    public int compare(List<String> a, List<String> b)
	    {
	    	if(a.get(2).compareTo(b.get(2))==0)
	    	{
	    		if(a.get(3)!=null && b.get(3)!=null) return a.get(3).compareTo(b.get(3));
	    		else return 0;
	    	}
	    	else return (a.get(2).compareTo(b.get(2)));
	    }
	}
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
    public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uT = request.getParameter("filter");
		if(uT.equalsIgnoreCase("admin")||uT.equalsIgnoreCase("enduser")||uT.equalsIgnoreCase("serviceengineer"))
		{
			Admin A = new Admin();
			try {
				ResultSet rs = A.filterUser(uT);
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> user = new ArrayList<>();
					user.add(rs.getString(1));
					user.add(rs.getString(2));
					user.add(rs.getString(4));
					user.add(rs.getString(7));
					lists.add(user);
					
				}
				Collections.sort(lists, new Sortbyroll());
				request.setAttribute("users", lists);
				request.setAttribute("filterty", uT);
				RequestDispatcher rd = request.getRequestDispatcher("viewUser.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(uT.equalsIgnoreCase("Finance")||uT.equalsIgnoreCase("Technical")||uT.equalsIgnoreCase("General"))
		{
			Admin A = new Admin();
			try {
				ResultSet rs = A.filterTicket(uT);
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
					ticket.add(rs.getString(6));
					ticket.add(rs.getString(7));
					if(rs.getTimestamp(8)!=null) ticket.add(rs.getTimestamp(8).toString());
					lists.add(ticket);
				}
				Collections.sort(lists, new SortbyrollTick());
				Collections.reverse(lists);
				request.setAttribute("Ticket", lists);
				RequestDispatcher rd = request.getRequestDispatcher("viewTicketAD.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
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
