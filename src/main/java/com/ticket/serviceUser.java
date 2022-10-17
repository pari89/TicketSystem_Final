package com.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Back.Admin;

/**
 * Servlet implementation class serviceUser
 */
@WebServlet("/serviceUser")
public class serviceUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serviceUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usertp = session.getAttribute("usertype1").toString();
		String setype= request.getParameter("setype");
		String usern = session.getAttribute("username1").toString();
		String pass = session.getAttribute("password1").toString();
		String em = session.getAttribute("email1").toString();
		Admin A = new Admin();
		boolean reg;
		try {
			reg = A.addServiceEngineer(usern, pass,setype,em);
			if(reg)
			{
				HttpSession session1 = request.getSession();
				session1.setAttribute("usertype",usertp);
				response.sendRedirect("sreg.jsp");
			}
			else
			{
				HttpSession session1 = request.getSession();
				session1.setAttribute("usertype",usertp);
				response.sendRedirect("freg.jsp");
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
