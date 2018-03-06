<%@ page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList"
    errorPage="error.jsp"
    isErrorPage="false"
    isThreadSafe="true"
    isELIgnored="false"
    info="this is a login page"
    session="true"
    trimDirectiveWhitespaces="true"
    buffer="99kb"
    
     autoFlush="true"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%
//int x = 100/0;
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
if(userid!=null && pwd!=null){
	if(userid.equals(pwd)){
		response.sendRedirect("index.jsp?uid="+userid);
	}
	else{
		%>
		<h2>Invalid Userid or Password....</h2>
	<% 	
	}
	//out.flush();
}
%> 

<div class="container">
<!-- This page is build by Amit -->
<%-- This Page is Build BY AMIT Userid is <%=userid %> Password is <%=pwd %> --%>
<h1>Login</h1>
<form action="login.jsp" method="post">
<div class="form-group">
<label>Userid</label>
<input type="text" class="form-control" placeholder="Type Userid Here" name="userid">
</div>
<div class="form-group">
<label>Password</label>
<input type="password" class="form-control" placeholder="Type Userid Here" name="pwd">
</div>
<div class="form-group">
<button type="submit" class="btn btn-primary">Login</button>
<button type="reset" class="btn btn-danger">Clear</button>

</div>
</form>
</div>
</body>
</html>