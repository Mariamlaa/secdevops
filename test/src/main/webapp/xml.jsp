<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gytu</title>
</head>
<body>
	<%
    FileInputStream is = new FileInputStream(new File("C:\\Users\\mlaachouc\\eclipse-workspace\\test\\src\\main\\webapp\\test.xml"));
	
try {
    OutputStream os = response.getOutputStream();
    
    byte[] b = new byte[1024];
    int i;
    while ((i = is.read(b)) > -1) {
        response.getOutputStream().write(b, 0, i);
    }
} finally {
    is.close();
}
    %>
    
</body>
</html>