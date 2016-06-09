<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi hello
<br/>
<c:if test="${companyname=='jpmorgan'}">
		<c:set var="propercompanyname" value="JP Morgan" />
	</c:if>
	<c:if test="${companyname=='directi'}">
		<c:set var="propercompanyname" value="Direct i" />
	</c:if>
	
<%-- 	<a href="<c:url value="/JobPosts/companyname/" />"><h2>${propercompanyname}</h2></a><br/><br/> --%>
	
	<a href="<c:url value="/JobPost?companyname=DirectI" />"><h3>View Post</h3></a>
	<br/>
</body>
</html>