<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Register</h1>
<form method="POST">
First Name: <input type="text" value="<%=request.getParameter("firstName") != null ? request.getParameter("firstName") : "" %>" name="firstName" /> <span> <c:out value="${firstNameError}" /> </span> <br/> 
Last Name: <input type="text" name="lastName" /><br/>
Username: <input type="text" name="userName" /><br/>
Password: <input type="password" name="password" /><br/>

<input type="submit" value="Register" />
</form>
</body>
</html>