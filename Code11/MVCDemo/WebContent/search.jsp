<%@page import="com.brainmentors.apps.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.brainmentors.apps.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="tcs" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.red{
background-color: red;
}
.green{
background-color: green;
}

</style>
<tcs:head/>
</head>
<body>
<tcs:calendar txtname="dob" months="1"/>
<tcs:calendar txtname="doj" months="2"/>
<tcs:calendar txtname="emi" months="4"/>

<tcs:date country="IN" lang="hi"/>
<tcs:date country="FR" lang="fr"/>
<form action='searchctrl'>
<label>Search By Salary</label>
<input type="text" name="searchsal" placeholder="Type to Search ">
<button type='submit'>Search</button>
</form>
<br>
<c:if test="${emplist.size() gt 0 }">
<table border="1">
<tr>
<th>Id</th>
<th>Name</th>
<th>Salary</th>
</tr>
<c:forEach items="${emplist}" var="emp">
<c:if test="${emp.salary <= 12000 && emp.salary>=9000 }">
<tr class='red'>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.salary}</td>
</tr>
</c:if>
<c:if test="${emp.salary gt 12000 }">
<tr class='green'>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.salary}</td>
</tr>
</c:if>
</c:forEach>
</table>
</c:if>
</body>
</html>









