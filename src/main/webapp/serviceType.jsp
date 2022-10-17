<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add End User</title>
    <link rel = "stylesheet" href = "addUser.css">
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
    <form action="admin.jsp" method="post">
        <button class="t-button">HOME</button>
    </form>
   </div>
   <div class="card">
    <h1>SERVICE ENGINEER TYPE</h1><br>
    <form action="serviceUser" method=post>
        <label for="setype">Service Engineer type</label>
        <select name="setype" id="setype" class="t-box">
        	<option value="General">General</option>
        	<option value="Finance">Finance</option>
        	<option value="Technical">Technical</option>
        </select><br><br><br><br><br>
        <button class="b-button">REGISTER</button>
        
    </form>
    
   </div>
</body>
</html>