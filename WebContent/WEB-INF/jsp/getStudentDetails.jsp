<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of all Students</title>
</head>
<body>
<center><h1>List of ALl students</h1></center>
 <table border="2" width="70%" cellpadding="2">
	<tr><th>studentId</th><th>studentAge</th><th>studentName</th><th>studentEmail</th><th>Edit</th><th>Delete</th></tr>
     <c:forEach var="student" items="${getStudentDetails}">
    <tr>
    <td>${student.studentId}</td>
     <td>${student.studentAge}</td>
    <td>${student.studentName}</td>
    <td>${student.studentEmail}</td>
    <td>
     <form action="/MVC_Annotation/studentSingleUpdate" method="post">
      <input type='hidden' name='studentId' value=${student.studentId}>
      <input type="submit" value="edit"/>
     </form>
    </td>
    <td>
     <form action="/MVC_Annotation/studentDelete" method="post">
     <input type='hidden' name='studentId' value=${student.studentId}>
      <input type="submit" value="Delete"/>
     </form>
    </td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>