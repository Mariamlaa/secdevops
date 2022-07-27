<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="mod" method="post">
	<h1>Modifier des users</h1>
	<tr>
        <td>Entrer nom de user</td>
        <td><input type="text" name="fullname" ></td>
    </tr>
	<tr>
        <td>Entrer email de user</td>
        <td><input type="text" name="email" ></td>
    </tr> 
	<tr>
        <td>Entrer mdp de user</td>
        <td><input type="text" name="password" ></td>
    </tr> 
	<tr>
        <td>Entrer la ref de user</td>
        <td><input type="text" name="ref" ></td>
    </tr>
	<tr>
		<td><input type="submit" name="Action" value="Edit"></td>
	</tr>  
	</form>	
</body>
</html>