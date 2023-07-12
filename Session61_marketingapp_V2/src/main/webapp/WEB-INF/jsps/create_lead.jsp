<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>Create | Lead</h2>
	<hr>
	<form action="saveLead" method="post">
		<table border=1 align="center" style="margin: 0px auto;">
			<tr>
				<th colspan="7" align="center" bgcolor="lightgrey"><font
					size="5">Create New Lead </font></th>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile" /></td>
			</tr>

			<tr>
				<td style="text-align: center" colspan="2"><input
					type="submit" value="save" /></td>
			</tr>
		</table>
	</form>

	${msg}

</body>
</html>