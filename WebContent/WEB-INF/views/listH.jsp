<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty ihs}">
	<table align="left" border="1">
<tr>
			<th>Comps</th>
			<th>It:</th>
		<th>Prod:</th>
		<th>Elex:</th>
		<th>Year:</th>
		
		</tr>
		<c:forEach items="${ihs}" var="a">
			<tr>
			
			<td>${a.comps}</td>
				
			<td>${a.it}</td>	
									<td>${a.prod}</td>	
									<td>${a.elex}</td>	
								
								<td>${a.year}</td>	
								
								
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
