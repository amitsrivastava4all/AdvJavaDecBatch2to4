<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.errorMessage{
color:red;
font-style: italic;
}
</style>

</head>
<body>


<s:a action="welcome">Index</s:a>
<h1><s:text name="login.title"/></h1>
<s:form  action="login" method="post">
<s:textfield  name="userid" key="login.userid" />

<s:password  name="password" key="login.password"/>


<s:submit />

</s:form>

</body>
</html>







