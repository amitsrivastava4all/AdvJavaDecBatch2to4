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
	 response.setHeader("Expires", "-1");

	  // Set standard HTTP/1.1 no-cache headers.
	  response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

	  // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
	  response.addHeader("Cache-Control", "post-check=0, pre-check=0");

	  // Set standard HTTP/1.0 no-cache header.
	  response.setHeader("Pragma", "no-cache");
	if(session == null){
		response.sendRedirect("welcome");
	}
	else{
		String urlWithSessionId = response.encodeURL("logout");
		System.out.println("Log out "+urlWithSessionId);
		String color = WelcomeServlet.checkCookiePresent(request);
		color = color!=null?color:"yellow";
		out.println("<html><body bgcolor='"+color+"'><form action='"+urlWithSessionId+"'><button>Logout</button></form>");
	out.println("Welcome to DashBoard "+session.getAttribute("userid")+" Discount is "+request.getParameter("dis"));
	out.println("</body></html>");
	out.close();
	}
	}

}








