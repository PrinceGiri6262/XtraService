<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List | Lead</h2>
	<hr>
    <table border=1 align="center" style="margin: 0px auto;" >
		 <tr><th colspan="7" align="center" bgcolor="lightgrey" ><font size="5"> LIST OF LEADS </font></th></tr>
        <tr bgcolor="lightgrey">
          <th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
    </tr>
		<c:forEach var="lead" items="${leads}">
			<tr>
				<th>${lead.firstName }</th>
				<th>${lead.lastName }</th>
				<th>${lead.email }</th>
				<th>${lead.mobile }</th>
				<th><a href="delete?id=${lead.id}" >Delete</a></th>
				<th><a href="update?id=${lead.id}" >Update</a></th>
			</tr>
		</c:forEach>
	</table>






</body>
</html>