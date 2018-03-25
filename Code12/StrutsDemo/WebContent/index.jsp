<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>First Page <s:property value="message"/></h1>
<s:iterator var="c" value="country" >
${c}
</s:iterator>
<s:select list="country">
</s:select>
<s:select list="qualification" headerKey="0" headerValue="select">
</s:select>
<s:radio name="c" list="qualification"></s:radio>
</body>
</html>









