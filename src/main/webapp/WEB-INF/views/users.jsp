<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Users List</h1>
<c:forEach items="${usersList}" var="user" >
<li id="user_<c:out value="user.userName"/>">
<div class="spittleMessage">
<c:out value="${user.userName}" />
</div>
<div>
<span class="spittleTime"><c:out value="${user.firstName}" /></span>
<span class="spittleLocation">
    <c:out value="${user.lastName}" />
</span>
</div>
</li>
</c:forEach>
</body>
</html>