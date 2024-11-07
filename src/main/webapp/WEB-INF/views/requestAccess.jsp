<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
         <form action="RequestServlet" method="post">
    Software: <select name="software">
        <!-- Populate with available software -->
    </select><br>
    Access Type: <select name="access_type">
        <option value="Read">Read</option>
        <option value="Write">Write</option>
        <option value="Admin">Admin</option>
    </select><br>
    Reason: <textarea name="reason"></textarea><br>
    <input type="submit" value="Request Access">
</form>
         
</body>
</html>