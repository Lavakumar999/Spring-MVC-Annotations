<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>

   <body>
      <h2>${sucessORfail}</h2>
      <table border=1>
         <tr>
            <td>StudentName</td>
            <td>${studentName}</td>
         </tr>
         <tr>
            <td>StudentAge</td>
            <td>${studentAge}</td>
         </tr>
         <tr>
            <td>StudentEmail</td>
            <td>${studentEmail}</td>
         </tr>
      </table>  
   </body>
   
</html>