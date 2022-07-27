<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="test.User"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">
      <a href="addUser.jsp">Add New User</a><br>
    </h2>
      
    <h1 align="center">List of Users</h1>
    <table border="1" align="center" cellpadding="5">
      <tr>
        <th>FullName</th>
        <th>Email</th>
        <th>Password</th>
        <th>Ref</th>
      </tr>
      <%
      String jdbcURL = "jdbc:mysql://localhost:3306/auth";
      String dbUser = "root";
      String dbPassword = "root";

      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
      while(resultSet.next()){     
      %>
      
      <tr>
      	<td><%
            out.print(resultSet.getString(1));
          %>
        </td>
        <td><%
            out.print(resultSet.getString(2));
          %>
        </td>
        <td><%
            out.print(resultSet.getString(3));
          %>
        </td>
        <td><%
            out.print(resultSet.getString(4));
          %>
        </td>
        
        <form action="mod" method="post">
          <td><a value="Edit" name="Action"
            href="edit.jsp?ref=<%=resultSet.getString(4)%> ">Edit</a> <input
            type="hidden" name="j" value="<%=resultSet.getString(4) %>"></td>
            </form>
      </tr>
      <%} %>
	</table>
</body>
</html>