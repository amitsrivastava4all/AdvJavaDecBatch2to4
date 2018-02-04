package com.brainmentors.apps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false);
		if(session ==null){
			response.sendRedirect("welcome");
		}
		else
		{
			session.removeAttribute("userid");
			session.invalidate();
			PrintWriter out = response.getWriter();
			out.println("U Logout SuccessFully");
			out.close();
		}
		
	}

}





