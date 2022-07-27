<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="test.User"%>

<% 
	User user = (User) session.getAttribute("user");
    if(user!=null){
        response.sendRedirect("home.jsp");

    }
%>


 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

</head>
<body>

	<div style="text-align: center">
        <h1>Login</h1>
        <form action="home" method="post">  
            <label for="email">Email:</label>
            <input name="email" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message} <!-- if info wrong -->
            <br><br>           
            <button type="submit">Login</button>
        </form>
    </div>
    
  
</body>

</html>