<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="icon" type="image/x-icon" href="images\icon.png">
    <link rel = "stylesheet" href = "login.css">
</head>
<body>
   <div class="toolbar">
	    <form action="login.jsp" method="get">
            <button class="t-button">LOGIN</button>
        </form>
   </div>
   <div class="card">
    <h1>FORGOT PASSWORD</h1><br>
    <form action="ForgetPass" method="post">
        <label for="username" class="text1">Username</label><br>
        <input class="t-box" type="text" id="username" name="username"><br><br><br><br>
        <button class="b-button" >SEND MAIL</button>
    </form>
   </div>
</body>
</html>