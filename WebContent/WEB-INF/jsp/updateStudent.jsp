<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Updation Form</title>
</head>
<body>
<center><h1>Student Updation form</h1></center>
 <form action='/MVC_Annotation/studentUpdateValue' method='post'>
<table border=1 width="300px">
    <tr><td>StudentId</td><td><input type='text' name='studentId' size="50" value=${studentId}></td></tr>
    <tr><td>StudentAge</td> <td><input type='text' name='studentAge' size="50" value=${studentAge}></td></tr>
    <tr><td>StudentName</td><td><input type='text' name='studentName'  size="50"value=${studentName}></td></tr>
    <tr><td>StudentEmail</td><td><input type='text' name='studentEmail' size="50" value=${studentEmail}></td></tr>
    <tr><td colspan=2><center><input type="submit" value="update"/></center></td></tr>
</table>
</form>
</body>
</html>