<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
Interested in higher studies
</h1>
<form action="saveH" method="post">

<h1>Interested in higher studies details</h1>
Year:<BR>
<input type="text" name="year" value="${ihs.year}"><BR>
<BR>

Comps:<BR>
<input type="text" name="comps" value="${ihs.comps}"><BR>
<BR>
Elex:<BR>
<input type="text" name="elex" value="${ihs.elex}"><BR>
<BR>

Prod:<BR>
<input type="text" name="prod" value="${ihs.prod}"><BR><BR>

IT:<BR>
<input type="text" name="it" value="${ihs.year}">
<BR><BR>


<h1>Internship Placed:</h1>
Year:<BR>
<input type="text" name="years" value="${ips.year}"><BR>
<BR>

Comps:<BR>
<input type="text" name="compss" value="${ips.comps}"><BR>
<BR>
Elex:<BR>
<input type="text" name="elexs" value="${ips.elex}"><BR>
<BR>

Prod:<BR>
<input type="text" name="prods" value="${ips.prod}"><BR><BR>

IT:<BR>
<input type="text" name="its" value="${ips.it}">
<BR><BR>
<input type="submit" value="Submit"/>
</form>

</body>

</html>