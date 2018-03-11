<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="txtname" type ="java.lang.String" required="true" %>
<%@attribute name="months" type="java.lang.Integer" required="true" %>
<input type="text" id="<%=txtname%>">
<script>
  $( function() {
    $( "#<%=txtname%>" ).datepicker({
      numberOfMonths: <%=months%>,
      showButtonPanel: true
    });
  } );
  </script>
