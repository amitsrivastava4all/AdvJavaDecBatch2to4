<%@tag import="java.util.Locale"%>
<%@tag import="java.text.DateFormat"%>
<%@ tag language="java" import="java.util.Date" pageEncoding="UTF-8"%>
<%@attribute  name="country" type="java.lang.String" required="true" %>
<%@attribute  name="lang" type="java.lang.String" required="true" %>
<%
Locale l = new Locale(lang,country);
Date d  = new Date();
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,l);
String formattedDate  = df.format(d);
%>
<b><%=formattedDate %></b>
<br>
