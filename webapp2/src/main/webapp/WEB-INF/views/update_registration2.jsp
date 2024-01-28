<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Update Registration Here.....</h2>
	<form action="updateReg" method="post">
		<pre>
		<input type= "hidden" name = "id" value = "${reg.id}"/>
      First Name <input type="text" name="firstName"value="${reg.firstName}" />
      Last Name <input type="text" name="lastName"value="${reg.lastName}" />  
      Email <input type="text" name="email"value="${reg.email}" />
      Mobile <input type="text" name="mobile"value="${reg.mobile}" />
      <input type="submit" value ="update" />
   
  
  </pre>

	</form>
	
</body>
</html>