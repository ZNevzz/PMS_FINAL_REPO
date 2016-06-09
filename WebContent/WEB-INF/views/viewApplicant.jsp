
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Applicants</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<c:if test="${!empty users}">
		<table border="1">
			<tr>
				<th>User Roll No.</th>
				
			</tr>
			<c:forEach items="${users}" var="ud">
				<tr>
					<td><c:out value="${ud.username}" /></td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/><br/>
	<center><h3>Input Student To Be Notified</h3></center>
	<br/><br/>
		<form:form method="POST" action="NotifyStudent">
			
			<table>
				
				<tr>
					<!-- 
					<td>UserName/Roll No. :</td>
					<td> <input name="userName" /> </td> -->
					<td><form:label path="userName">User name:</form:label></td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				
				<tr>
					<p>
						<font size="5" color="red" face="verdana">${errorMsg}</font>
					</p>
				</tr>
				
				<tr>
			
				<td colspan="2"><input type="submit" value="Notify"></td>
			</tr>
				
			</table>
	
		</form:form>

</body>
</html>