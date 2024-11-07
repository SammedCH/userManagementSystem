<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
      <form action="SoftwareServlet" method="post">
    Software Name: <input type="text" name="name"><br>
    Description: <textarea name="description"></textarea><br>
    Access Levels: <input type="checkbox" name="access_levels" value="Read">Read
                  <input type="checkbox" name="access_levels" value="Write">Write
                  <input type="checkbox" name="access_levels" value="Admin">Admin<br>
    <input type="submit" value="Create Software">
</form>
          
</body>
</html>