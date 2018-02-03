package com.brainmentors.apps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brainmentors.dao.UserDAO;
import com.brainmentors.dto.UserDTO;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	int counter ;
	@Override
	public void init(){
		System.out.println("I Will Call Only Once...");
		counter = 1;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
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
				response.sendRedirect("dashboard?uid="+userid+"&dis="+discount);
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
	
	private String design(String msg){
		String loginDesign = "<!DOCTYPE html> <html lang='en'>  <head>     <meta charset='UTF-8'>    "
				+ " <meta name='viewport' content='width=device-width, initial-scale=1.0'>     <meta "+
" http-equiv='X-UA-Compatible' content='ie=edge'>     <title>Document</title> </head>  <body>      <h1>Login "
+" page</h1> <h2> "+msg+" </h2>    <form method='post' action='welcome'>         <table>             <tr>   "+ 
 "           <td><label for=''>Userid</label></td>                 <td><input "+
" type='text' name='userid' placeholder='Type Userid Here'></td>             </tr>             <tr>     "+  
   "      <td><label for=''>Password</label></td>                 <td><input "+
" type='password' name='pwd' placeholder='Type Password Here'></td>             </tr>             <tr>  "+   
      "     <td><button>Login</button></td>                 <td><button>Clear "+
"All</button></td>             </tr>         </table>     </form> </body>  </html> ";
	return loginDesign;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println(design(""));
		//out.println("Hello User U Visited..."+counter);
		//counter++;
		//out.println("Hi ");
		out.close();
	}
	

}
