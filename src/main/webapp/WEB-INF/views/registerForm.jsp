<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
<title>Registration</title>
<st:url value="/resources/css/layout.css" var="layoutCss" />
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />
<link href="${layoutCss}" rel="stylesheet" />
</head>
<body>
<h1>Register</h1>
<sf:form method="POST" commandName="user">
<sf:label path="firstName" cssErrorClass="error"> <st:message code="user.firstName"/> </sf:label> <sf:input path="firstName" /> <sf:errors path="firstName" cssClass="error"/> <br/> 
Last Name: <sf:input path="lastName" /><br/>
Username: <sf:input path="userName" /><br/>
Password: <sf:password path="password" /><br/>

<input type="submit" value="Register" />
</sf:form>
</body>
</html>