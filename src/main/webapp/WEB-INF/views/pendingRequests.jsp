<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <table>
    <!-- Populate with pending requests -->
    <tr>
        <td>Employee Name</td>
        <td>Software</td>
        <td>Access Type</td>
        <td>Reason</td>
        <td>Action</td>
    </tr>
    <!-- Loop through requests -->
    <tr>
        <td>John Doe</td>
        <td>Software A</td>
        <td>Read</td>
        <td>For development</td>
        <td>
            <form action="ApprovalServlet" method="post">
                <input type="hidden" name="request_id" value="1">
                <input type="submit" name="action" value="approve"> 
                <input type="submit" name="action" value="reject">
            </form>
        </td>
    </tr>
</table>
     
</body>
</html>