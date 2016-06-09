
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Applicant</title>
</head>
<body>
	<h2>Select the company to view applicants</h2>
	<form:form method="POST" action="SubmitCompany">
		<table>

			<tr>
				<td><h3>Company :</h3></td>
				<td><select name="company">

						<option value="01">TCS</option>
						<option value="02">L&T</option>
						<option value="03">IBM</option>
						<option value="04">JPMorgan</option>
						<option value="05">Direct I</option>
						<option value="06">ZS</option>
						<option value="07">Radio Mirchi</option>
						<option value="08">Accenture</option>
						<option value="09">Fr. Agnel</option>
					
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search" /></td>
			</tr>
			<tr>
				<td><h2><font color="red"><center>${errorMsg}</center></font></h2></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>