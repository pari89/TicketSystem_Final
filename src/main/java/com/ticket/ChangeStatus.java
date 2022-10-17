package com.ticket;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Back.ServiceEngineer;

/**
 * Servlet implementation class ChangeStatus
 */
@WebServlet("/ChangeStatus")
public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession s = request.getSession();
		String cS = request.getParameter("status");
		ServiceEngineer se = new ServiceEngineer();
		try {
			if(cS==null)
			{
				HttpSession session = request.getSession();
				String un = (String) session.getAttribute("username");
				ResultSet rs1 = se.SEgetType(un);
				rs1.next();
				String ut = rs1.getString(1);
				//System.out.println(ut);
				ResultSet rs = se.viewTicketsL(ut);
				System.out.println(rs);
				List<List<String>> Ticket = new ArrayList<>();
				while(rs.next())
				{
					List<String> l = new ArrayList<>();
					l.add(rs.getString(1));
					l.add(rs.getString(2));
					l.add(rs.getString(3));
					l.add(rs.getString(4));
					l.add(rs.getString(6));
					l.add(rs.getString(7));
					l.add(rs.getString(8));
					Ticket.add(l);
				}
				request.setAttribute("Ticket", Ticket);
				request.setAttribute("sub","As you have no ticketa please select the ticket you want to resolve.");
				RequestDispatcher rd = request.getRequestDispatcher("SelectCH.jsp");
				rd.forward(request, response);
			}
			else if(cS.equalsIgnoreCase("close")||cS.equalsIgnoreCase("hold")||cS.equalsIgnoreCase("not assigned") )
			{
				int tN = Integer.parseInt(request.getParameter("ticketID"));
				boolean f = se.changeStatus(tN, cS);
				if(f)
				{
					ResultSet rs1 = se.getType(tN);
					rs1.next();
					ResultSet rs = se.viewTicketsL(rs1.getString(3));
					//System.out.println(rs);
					List<List<String>> Ticket = new ArrayList<>();
					while(rs.next())
					{
						List<String> l = new ArrayList<>();
						l.add(rs.getString(1));
						l.add(rs.getString(2));
						l.add(rs.getString(3));
						l.add(rs.getString(4));
						l.add(rs.getString(6));
						l.add(rs.getString(7));
						l.add(rs.getString(8));
						Ticket.add(l);
					}
					request.setAttribute("Ticket", Ticket);
					request.setAttribute("sub","Status Change successful! As you have relieved the ticket please select the next ticket you want to resolve.");
					RequestDispatcher rd = request.getRequestDispatcher("SelectCH.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", "Ticket status could not be changed");
					RequestDispatcher rd = request.getRequestDispatcher("changeUs.jsp");
					rd.forward(request, response);
				}
			}
			else if(cS.equalsIgnoreCase("open"))
			{
				int tN = Integer.parseInt(request.getParameter("ticketID"));
				boolean f = se.changeStatus(tN, cS);
				if(f)
				{
					ResultSet rs = se.getType(tN);
					rs.next();
					List<String> Ticket = new ArrayList<>();
					Ticket.add(rs.getString(1));
					Ticket.add(rs.getString(2));
					Ticket.add(rs.getString(3));
					Ticket.add(rs.getString(5));
					Ticket.add(rs.getString(6));
					request.setAttribute("Ticket", Ticket);
					RequestDispatcher rd = request.getRequestDispatcher("open.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", "One ticket is already opened. You are unavaialable right now. \n Please complete the present ticket and close it.");
					RequestDispatcher rd = request.getRequestDispatcher("changeUs.jsp");
					rd.forward(request, response);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
