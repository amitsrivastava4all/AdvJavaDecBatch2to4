package com.brainmentors.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.brainmentors.dao.UserDAO;
import com.brainmentors.dto.UserDTO;

/**
 * Servlet implementation class WelcomeServlet
 */
//@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	int counter ;
	@Override
	public void init(){
		System.out.println("I Will Call Only Once...");
		counter = 1;
	}
	
	public static String checkCookiePresent(HttpServletRequest request){
		String color = null;
		Cookie cookies[] = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("myfavcolor")){
					color = cookie.getValue();
					break;
				}
			}
		}
		return color;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		this.request = request;
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		String color= request.getParameter("mycolor");
		String cookieColor = checkCookiePresent(request);
		if(cookieColor==null){
			Cookie newCookie = new Cookie("myfavcolor",color);
			newCookie.setMaxAge(365*24*60*60);
			response.addCookie(newCookie);
		}
		String currentButton = request.getParameter("btn");
		if(currentButton.equals("register")){
			PrintWriter out = response.getWriter();
			out.println("U Click on Register");
			return ;
		}
		//String message = "";
		System.out.println("Userid "+userid+" Password "+password);
		UserDTO userDTO = new UserDTO(userid, password);
		UserDAO userDAO = new UserDAO();
		PrintWriter out = response.getWriter();
		String message="";
		int discount = 10;
		try {
			//message = userDAO.isUserExist(userDTO)?"Welcome "+userid:"Invalid Userid or Password";
			//response.getWriter().println(design(message));
			if(userDAO.isUserExist(userDTO)){
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(2*60);
				System.out.println(session.getId());
				session.setAttribute("userid", userid);
				//session.setAttribute("items", "Mobiles");
				String urlWithSessionId = response.encodeRedirectURL("dashboard.shop"); // URL + SessionID
				RequestDispatcher rd = request.getRequestDispatcher(urlWithSessionId);
				request.setAttribute("pincode", 12345);
				rd.forward(request, response);
				
				//response.sendRedirect(urlWithSessionId);
				//response.sendRedirect("dashboard");
				//response.sendRedirect("dashboard?uid="+userid+"&dis="+discount);
			}
			else{
				response.getWriter().println(design("Invalid Userid or Password"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println(e);
			e.printStackTrace();
		}
//		if(userid.equals(password)){
//			message = "Welcome "+userid;
//		}
//		else{
//			message = "Invalid Userid or Password";
//		}
		
	}
	private HttpServletRequest request;
	private String design(String msg){
		String showColorOption = "";
		if(checkCookiePresent(this.request)==null){
			
 showColorOption =  "<tr><td>Color</td><td><input type='color' name='mycolor'></td></tr> ";
		}
		
		String loginDesign = "<!DOCTYPE html> <html lang='en'>  <head>     <meta charset='UTF-8'>    "
				+ " <meta name='viewport' content='width=device-width, initial-scale=1.0'>     <meta "+
" http-equiv='X-UA-Compatible' content='ie=edge'>     <title>Document</title> </head>  <body>      <h1>Login "
+" page</h1> <h2> "+msg+" </h2>    <form method='post' action='welcome'>         <table>             <tr>   "+ 
 "           <td><label for=''>Userid</label></td>                 <td><input "+
" type='text' name='userid' placeholder='Type Userid Here'></td>             </tr>             <tr>     "+  
   "      <td><label for=''>Password</label></td>                 <td><input "+
" type='password' name='pwd' placeholder='Type Password Here'></td> "
+ "            </tr>"+showColorOption+
  "  <tr> "+
   "     <td><button value='login' name='btn'>Login</button> <button value='register' name='btn'>Register</button></td>                 <td><button>Clear "+
"All</button></td>             </tr>         </table>     </form> </body>  </html> ";


	return loginDesign;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		this.request = request;
		PrintWriter out = response.getWriter();
		out.println(design(""));
		//out.println("Hello User U Visited..."+counter);
		//counter++;
		//out.println("Hi ");
		out.close();
	}
	

}
