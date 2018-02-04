package com.brainmentors.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String userid = request.getParameter("uid");
	HttpSession session = request.getSession(false);
	if(session == null){
		response.sendRedirect("welcome");
	}
	else{
	 out.println("<html><body><form action='logout'><button>Logout</button></form>");
	out.println("Welcome to DashBoard "+session.getAttribute("userid")+" Discount is "+request.getParameter("dis"));
	out.println("</body></html>");
	out.close();
	}
	}

}








