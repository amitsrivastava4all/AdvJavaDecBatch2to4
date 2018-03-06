<%@page import="com.brainmentors.apps.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.brainmentors.apps.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action='search.jsp'>
<label>Search By Salary</label>
<input type="text" name="searchsal" placeholder="Type to Search ">
<button type='submit'>Search</button>
</form>
<br>
<%
String tempSal = request.getParameter("searchsal");
if(tempSal!=null && tempSal.trim().length()>0){
	double salary = Double.parseDouble(tempSal);
	DAO dao = new DAO();
	ArrayList<EmployeeDTO> empList =   dao.searchBySalary(salary);
%>
<%@include file="searchresult.jsp"  %>
	<%
}
%>
<%@include file="footer.jsp" %>
</body>
</html>