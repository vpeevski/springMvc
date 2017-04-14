<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
	<title>Hello Sping MVC</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
	</head>
	<body>
		<h1>Welcome to Spring MVC</h1>
		<a href="<c:url value="/" />">Home</a> |
		<a href="<c:url value="/register" />">Register</a> |
		<a href="<c:url value="/users" />">All users</a>
	</body>
</html>