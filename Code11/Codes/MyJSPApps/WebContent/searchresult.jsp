<fieldset>
<legend>Search Result</legend>
<table border="1">
<thead>
<tr>
<td>Id</td>
<td>Name</td>
<td>Salary</td>
</tr>
</thead>
<tbody>
<%
String myClass = "red";
for(EmployeeDTO emp: empList){
	myClass = "red";
	if(emp.getSalary()>20000){
		myClass = "green";
	}
	else
	if(emp.getSalary()<=20000 && emp.getSalary()>9000){	
		myClass = "yellow";
	}
%>
<tr class="<%=myClass%>">
<td><%=emp.getId() %></td>
<td><%=emp.getName() %></td>
<td><%=emp.getSalary() %></td>
</tr>
<%
}
%>
</tbody>	
</table>
</fieldset>






