<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*" %>

<% Class.forName("org.postgresql.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Job Details </TITLE>
    </HEAD>

    <BODY>
        <H1>Job Details</H1>
		<h2>Welcome to ${companyname}</h2>
		<c:if test="${companyname=='jpmorgan'}">
		<c:set var="propercompanyname" value="Accenture" />
	</c:if>
	<c:if test="${companyname=='directi'}">
		<c:set var="propercompanyname" value="Direct I" />
	</c:if>
	
	<br/>
	<c:if test="${!empty job}">
	<table align="left" border="1">
		<tr>
			<!-- <th>Job ID</th>
			<th>Event Id</th> -->
			<th>Job Description</th>
			<th>Category</th>
			<th>Ctc</th>
			<th>Skills</th>
			<th>Document</th>
	<!--	<th>Edit Or Delete</th> 	-->
		</tr>


<%-- 		 <c:forEach items="${job}" var="profile">
 --%>			<tr>
		<%-- 	<td><c:out value="${job.job_id}"/></td> 
				<td><c:out value="${job.event_id}"/></td>	 --%>		
 				<td><c:out value="${job.job_description}"/></td>
				<td><c:out value="${job.job_category}"/></td>
				<td><c:out value="${job.ctc}"/></td>
				<td><c:out value="${job.skills_required}"/></td>
				<td><c:out value="${job.docs_required}"/></td>
<%-- 			<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td> --%>
			</tr>
<%-- 		</c:forEach> --%>
	</table>
	
	
	
	
	
	
</c:if> 
    <%-- <% 
        
        System.out.println("");
            Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/placementdb2", "postgres", "root");
//String sql="select job_description,job_category,ctc,skills_required,docs_required from job_schema.job where job_id in (select job_id from job_schema.company_job where company_id in(select company_id from job_schema.company where company_name=?))";
			Statement statement = connection.createStatement();
			
            ResultSet resultset = 
 statement.executeQuery("select job_description,job_category,ctc,skills_required,docs_required from job_schema.job where job_id in (select job_id from job_schema.company_job where company_id in(select company_id from job_schema.company where company_name='Accenture'))");
            
        %>

        <TABLE BORDER="1">
            <TR>
<!--             select job_description,job_category,ctc,skills_required,docs_required from job_schema.job where job_id in (select job_id from job_schema.company_job where company_id in(select company_id from job_schema.company where company_name='Direct I'))"); -->
                <TH>Description</TH>
                <TH>Category</TH>
                <TH>CTC</TH>
                <TH>Skills Reqd.</TH>
                <TH>Documents Reqd.</TH>
                
                
            </TR>
            <% while(resultset.next()){ %>
            <TR>
                <TD> <%= resultset.getString(1) %></td>
                <TD> <%= resultset.getString(2) %></TD>
                <TD> <%= resultset.getString(3) %></td>
                <TD> <%= resultset.getString(4) %></TD>
                <TD> <%= resultset.getString(5) %></td>
                
            </TR>
            <% } %>
        </TABLE> --%>
    </BODY>
</HTML>



<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <sql:setDataSource var="datasource"
                 driver="org.postgresql.Driver"
                    url="jdbc:postgresql://localhost:5432/placementdb2"
                   user="postgres" password="root"/>


<sql:query var="details" dataSource="${datasource}">
select job_description,ctc from job_schema.job
where job_id in 
(
select job_id from job_schema.company_job
where company_id in
(
select company_id from job_schema.company
where company_name='Accenture'
)
)
</sql:query> 


<html>
<head>
<title>All Jobs</title>
</head>
<body>
<h1>List Of Jobs</h1><br/><br/>
<h1>Welcome to ${companyname}</h1>
<h3><a href="addProfile.html">Add New Profile</a></h3>
<h3><a href="<c:url value="/addProfile" />">Add New Profile chk</a></h3>
<h2><a href="form">Logout</a></h2>

 <c:if test="${!empty profiles}">
	<table align="left" border="1">
		<tr>
			<!-- <th>Job ID</th>
			<th>Event Id</th> -->
			<th>Job Description</th>
			<th>Category</th>
			<th>Ctc</th>
			<th>Skills</th>
			<th>Document</th>
	<!--	<th>Edit Or Delete</th> 	-->
		</tr>


		<c:forEach items="${profiles}" var="profile">
			<tr>
			<td><c:out value="${profile.job_id}"/></td> 
				<td><c:out value="${profile.event_id}"/></td>			
 				<td><c:out value="${profile.job_description}"/></td>
				<td><c:out value="${profile.job_category}"/></td>
				<td><c:out value="${profile.ctc}"/></td>
				<td><c:out value="${profile.skills_required}"/></td>
				<td><c:out value="${profile.docs_required}"/></td>
			<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</c:if> 
</body>
</html> 
 --%>