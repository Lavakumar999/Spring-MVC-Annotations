<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>Insert Student Information</h2>
      <form:errors path="student.*"></form:errors>
      <form:form method = "POST" action = "/MVC_Annotation/addStudent" commandName="student">
         <table>
            <tr>
               <td><form:label path = "studentName">studentName</form:label></td>
               <td><form:input path = "studentName" /></td>
            </tr>
            <tr>
               <td><form:label path = "studentAge">StudentAge</form:label></td>
               <td><form:input path = "studentAge" /></td>
            </tr>
            <tr>
               <td><form:label path = "studentEmail">studentEmail</form:label></td>
               <td><form:input path = "studentEmail" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Insert"/>
               </td>
            </tr>
         </table>  
      </form:form>
      
      <center><h2>Select here all Students</h2></center>
      <form action="/MVC_Annotation/getAllStudents" method="post">
           <input type="submit" value="select All"/> 
      </form>
      <center><h1>Get single member details here</h1></center>
	   <form action="/MVC_Annotation/getStudent" method="post">
		  Enter student id to want to see Details<input type="text" name="studentId"/>
		  <input type="submit" value="View"/>
	   </form>
   </body>
   
</html>