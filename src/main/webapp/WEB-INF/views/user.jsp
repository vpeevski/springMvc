<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
<title>Welcome <c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></title>
<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1><st:message code="profile"/> </h1>
<div class="spittleView">
<div class="spittleMessage"><c:out value="${user.firstName}" /></div>
<div>
<span class="spittleTime"><c:out value="${user.lastName}" /></span>
</div>

<div>
<span class="spittleTime"><c:out value="${user.userName}" /></span>
</div>
</div>
</body>
</html>