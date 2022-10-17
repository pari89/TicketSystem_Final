<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Users</title>
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
        <form action="admin.jsp" method="get">
            <button class="t-button">HOME</button>
        </form>
    </div>
    <c:set var = "SE" scope = "session" value = "serviceengineer"/>
    <c:set var = "EU" scope = "session" value = "enduser"/>
    <c:set var = "A" scope = "session" value = "admin"/>
    <div class="card">
    <form action="Filter" method="post">
    	<c:set var = "type" scope = "session" value = "user"/>
            <select name="filter" id="filter" class="t-box">
            	<c:if test="${filterty==null }">
            		<option value="serviceengineer">Service Engineer</option>
            		<option value="admin">Admin</option>
            		<option value="enduser">End User</option>
            	</c:if>
            	<c:if test="${filterty==SE }">
            		<option value="serviceengineer">Service Engineer</option>
            		<option value="admin">Admin</option>
            		<option value="enduser">End User</option>
            	</c:if>
            	<c:if test="${filterty==EU }">
            		<option value="enduser">End User</option>
            		<option value="serviceengineer">Service Engineer</option>
            		<option value="admin">Admin</option>
            	</c:if>
            	<c:if test="${filterty==A }">
            		<option value="admin">Admin</option>
            		<option value="serviceengineer">Service Engineer</option>
            		<option value="enduser">End User</option>
            	</c:if>          	
            </select>
            <button class="b1-button">FILTER</button>
        </form><br><br><br>
        <h1>USERS</h1>
        
        <table>
            <tr>
              <th>System Code</th>
              <th>Username</th>
              <th>User type</th>
              <c:if test="${filterty==SE }">
              	<th>Service Engineer Type</th>
              </c:if>
            </tr>
            <c:forEach items="${users}" var="s">
	            <tr>
		            <td>${s.get(0)}</td>
		            <td>${s.get(1)}</td>
		            <td>${s.get(2)}</td>
		            <c:if test="${filterty==SE }">
		            	<td>${s.get(3)}</td>
		            </c:if>
	            </tr>
            </c:forEach>
          </table>
    </div>
</body>

</html>