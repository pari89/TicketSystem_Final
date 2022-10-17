<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select Ticket</title>
    <link rel="stylesheet" href="viewticket.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>
<%
	if(session.getAttribute("usertype")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<body>
    <div class="toolbar">
        <form action="service.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <div class="card">
    	${sub}
        <h1>SELECT TICKET</h1>
        <table>
            <tr>
              <th>Ticket ID</th>
              <th>Ticket Name</th>
              <th>Ticket Type</th>
              <th>End User raised</th>
              <th>Ticket Status</th>
              <th>Remarks/Comments</th>
              <th>Ticket Date</th>
            </tr>
            <c:forEach items="${Ticket}" var="s">
	            <tr>
	            	<c:forEach items="${s}" var="i">
	            		<td>${i}</td>
	            	</c:forEach>
	            </tr>
            </c:forEach>
          </table><br><br>
          <form action="SelectCH" method=post>
            <label for="ticketID" class="text1">Ticket ID</label><br>
            <select name="ticketID" id="ticketID" class="t-box">
	        	<c:forEach items="${Ticket}" var="s">
	            	<option value="${s.get(0)}">${s.get(0)}</option>
            	</c:forEach>
        	</select><br><br><br><br>
            <button class="b-button">SUBMIT</button>
        </form><br><br>
        <form action="service.jsp" method=post>
        <label for="ticketName" class="text1">If you do not want to select a ticket then select &nbsp;</label>
        	<button class="b1-button">HOME</button>
        </form>
    </div>
</body>

</html>