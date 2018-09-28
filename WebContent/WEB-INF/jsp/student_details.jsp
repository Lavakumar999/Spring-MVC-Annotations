<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student_details</title>
</head>
<body>
<table border=1>
    <tr><th>studentId</th><th>studentAge</th><th>studentName</th><th>studentEmail</th></tr>
    <tr>
    <td>${studentId}</td>
     <td>${studentAge}</td>
    <td>${studentName}</td>
    <td>${studentEmail}</td>
    </tr>
</table>
</body>
</html>