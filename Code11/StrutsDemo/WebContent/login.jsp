<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<s:form theme="simple" action="login" method="post">
<div class="form-group">
<label>Enter the UserId</label>
<s:textfield cssClass="form-control" name="userid" label="Enter the Userid"/>
</div>
<div class="form-group">
<label>Enter the Password</label>
<s:password cssClass="form-control" name="password" label="Enter the Password"/>
</div>
<div class="form-group">
<s:submit cssClass="btn btn-primary"/>
</div>
</s:form>
</div>
</body>
</html>







