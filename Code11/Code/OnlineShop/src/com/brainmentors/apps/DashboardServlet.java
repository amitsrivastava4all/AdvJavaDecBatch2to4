package com.brainmentors.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brainmentors.listeners.SessionCountListener;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard.shop")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	String userid = request.getParameter("uid");
	HttpSession session = request.getSession(false);
	//int x = 100/0;
	 response.setHeader("Expires", "-1");

	  // Set standard HTTP/1.1 no-cache headers.
	  response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

	  // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
	  response.addHeader("Cache-Control", "post-check=0, pre-check=0");

	  // Set standard HTTP/1.0 no-cache header.
	  response.setHeader("Pragma", "no-cache");
//	if(session == null){
//		response.sendRedirect("welcome");
//	}
//	else{
		String urlWithSessionId = response.encodeURL("logout.shop");
		System.out.println("Log out "+urlWithSessionId);
		String color = WelcomeServlet.checkCookiePresent(request);
		color = color!=null?color:"yellow";
		//out.println("<html><body bgcolor='"+color+"'>
		RequestDispatcher rd = request.getRequestDispatcher("header");
		request.setAttribute("mycolor", color);
		rd.include(request, response);
		int pincode = (Integer)request.getAttribute("pincode");
		String phone = this.getServletConfig().getInitParameter("phone");
		String phoneServletContext = this.getServletConfig().getServletContext().getInitParameter("phone");
		
		out.println("<div class='container'><form action='"+urlWithSessionId+"'><button class='btn btn-primary'>Logout</button></form>");
	out.println(phone+" " +phoneServletContext+"  Welcome to DashBoard Total User Login "+ SessionCountListener.getCounter() +" "+ pincode+ " "+session.getAttribute("userid")+" Discount is "+request.getParameter("dis"));
	out.println("</div>");
	RequestDispatcher rd2 = request.getRequestDispatcher("footer");
	rd2.include(request, response);
	//out.close();
	//}
	}

}








