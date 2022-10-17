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
        <h1>TICKETS ASSIGNED</h1>
        <table>
            <tr>
              <th>Ticket ID</th>
              <th>Ticket Name</th>
              <th>Ticket Type</th>
              <th>End User raised</th>
              <th>Ticket Status</th>
              <th>Remarks/Comments</th>
              <th>Ticket Time</th>
              <th> Status Change</th>
            </tr>
            <c:set var = "close1" scope = "session" value = "close"/>
            <c:set var = "hold1" scope = "session" value = "hold"/>
            <c:set var = "open1" scope = "session" value = "open"/>
            <c:set var = "not_assigned1" scope = "session" value = "not assigned"/>
            <c:forEach items="${Ticket}" var="s">
	            <tr>
	            	<c:forEach items="${s}" var="i">
	            		<td>${i}</td>
	            	</c:forEach>
	            	<c:set var = "status1" scope = "session" value = "${s.get(4)}"/>
	            	<td>
	            		<form action="ChangeStatus" method=post>
							<input type="hidden" name="ticketID" value="${s.get(0) }">
				            <c:if test="${status1==close1}">
				            	<select name="status" id="status" class="t-box">
					            	<option value="open">open</option>
					  				<option value="hold">hold</option>
					        	</select>
				            </c:if>
				            <c:if test="${status1==hold1}">
				            	<select name="status" id="status" class="t-box">
					            	<option value="open">open</option>
					  				<option value="close">close</option>
					        	</select>
				            </c:if>
				            <c:if test="${status1==open1}">
				            	<select name="status" id="status" class="t-box">
					            	<option value="close">close</option>
					  				<option value="hold">hold</option>
					        	</select>
				            </c:if>
				            <c:if test="${status1==not_assigned1}">
				            	<select name="status" id="status" class="t-box">
					            	<option value="open">open</option>
					        	</select>
				            </c:if>
				            <input class="b1-button" type="submit" value="CHANGE">
				        </form>
	            	</td>
	            </tr>
            </c:forEach>
          </table>
    </div>
</body>

</html>