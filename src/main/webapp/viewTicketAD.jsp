<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Tickets</title>
    <link rel="stylesheet" href="viewticket.css">
    <link rel="icon" type="image/x-icon" href="images\icon.png">
</head>
<%
	if(session.getAttribute("usertype")==null)
	{
		session.setAttribute("type", "user");
		response.sendRedirect("login.jsp");
	}
%>
<body>
    <div class="toolbar">
        <form action="admin.jsp" method="post">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <div class="card">
    	<form action="Filter" method="post">
    		<c:set var = "type" scope = "session" value = "user"/>
            <select name="filter" id="filter" class="t-box">
            	<option value="Finance">Finance</option>
            	<option value="Technical">Technical</option>
            	<option value="General">General</option>
            </select>
            <button class="b1-button">FILTER</button>
        </form><br><br><br>
        <h1>TICKETS</h1>
        <table>
            <tr>
              <th>Ticket ID</th>
              <th>Ticket Name</th>
              <th>Ticket Type</th>
              <th>End User raised</th>
              <th>Service Engineer Assigned</th>
              <th>Ticket Status</th>
              <th>Remarks/Comments</th>
              <th>Ticket Time</th>
            </tr>
            <c:forEach items="${Ticket}" var="s">
	            <tr>
	            	<c:forEach items="${s}" var="i">
	            		<td>${i}</td>
	            	</c:forEach>
	            </tr>
            </c:forEach>
          </table>
    </div>
</body>

</html>