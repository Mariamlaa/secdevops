<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.File" %>

<%
String url = request.getRequestURL().toString();
String dirToList = request.getRealPath(request.getServletPath());
File jsp = new File(dirToList);
File jspDirectory = jsp.getParentFile();
File[] dirContents = jspDirectory.listFiles();
%>

<table>

<%
 for (File file : dirContents) {
	String href = url + file;
  %>
	<tr><td><a href="<%= file.getName() %>"><%= file.getName() %></a></td></tr>
  <%
 }
%>

</table>

<div id="file_upload_level_1">
	<div>	
		<div>
			Choose the file to upload:
			 <form method="post" action="fileuploadservlet" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Upload" />
  </form>
</div>

