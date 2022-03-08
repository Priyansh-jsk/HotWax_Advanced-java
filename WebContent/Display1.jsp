<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="model.Party"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search by name</title>
</head>
<body>
	<form action="SearchServlet" method="post">
		<input class="form-control mr-sm-2" id="mySearch" type="text"
			placeholder="firstname" der="Search" name="firstname"
			aria-label="Search" onkeyup="myFunction()"> <input
			class="form-control mr-sm-2" id="mySearch" type="text"
			placeholder="lastname" der="Search" aria-label="Search" name=lastname
			" onkeyup="myFunction()">
		<button type="submit" name="button" value="Submit">Submit</button>

	</form>

	<%
		ArrayList<Party> arraylist = (ArrayList) request.getAttribute("Arraylist");
	%>
	</div>
	<br>
	<ul>
		<table class="table table-bordered">

			<tr>

				<th>fisrtname</th>
				<th>lastname</th>
				<th>address</th>
				<th>city</th>
				<th>zip</th>
				<th>state</th>
				<th>country</th>
				<th>phone</th>
				<th>Actions</th>
			</tr>

			<%
				if (arraylist != null) {
					for (Party party : arraylist) {
			%>
			<!-- <p>arraylist</p> -->
			<tr>
				<td><%=party.getFirstName()%></td>
				<td><%=party.getLastName()%></td>
				<td><%=party.getAddress()%></td>
				<td><%=party.getCity()%></td>
				<td><%=party.getZip()%></td>
				<td><%=party.getState()%></td>
				<td><%=party.getCountry()%></td>
				<td><%=party.getPhone()%></td>

			</tr>
			<%
				}
				}
			%>

		</table>
</body>
</html>