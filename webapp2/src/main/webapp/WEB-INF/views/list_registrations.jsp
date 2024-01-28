<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table border="1">
   <tr>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Email</th>
   <th>Mobile</th>
   <th>Delete</th>
   <th>Update</th>
   </tr>
   
   <c:forEach var = "reg" items = "${registrations}">
    <tr>
    <td>${reg.firstName}</td>
    <td>${reg.lastName}</td>
    <td>${reg.email}</td>
    <td>${reg.mobile}</td>
    <td><a href = "delete?id=${reg.id}">delete</a></td>
    <td><a href = "getRegistrationById?id=${reg.id}">update</a></td>
    
    </tr>
   
   </c:forEach>
  
  </table>
 
</body>
</html>