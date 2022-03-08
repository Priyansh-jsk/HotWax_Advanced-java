<%@page import="dao.searchAll"%>
<%@page import="java.util.List"%>
<%@page import="model.Party"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%!List<Party> mylist;%>
<html>

<head>
<title>Party Management App</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script>
	function myFunction() {
		// Declare variables
		var input, filter, ul, li, a, i, txtValue;
		input = document.getElementById('mySearch');
		filter = input.value.toUpperCase();
		ul = document.getElementById("myMenu");
		li = ul.getElementsByTagName('tr');

		for (i = 1; i < li.length; i++) {
			a = li[i].getElementsByTagName("td")[1];
			txtValue = a.textContent || a.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "";
			} else {
				li[i].style.display = "none";
			}
		}
	}
</script>
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<li><a href="#" class="navbar-brand">Party Management App</a></li>
			</div>

			<ul class="navbar-nav">

				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<nav class="navbar navbar-light bg-light">
		<form action="SearchServlet" method="post">
			<input class="form-control mr-sm-2" id="mySearch" type="text"
				placeholder="search" der="Search" name="firstname"
				aria-label="Search" onkeyup="myFunction()"> <input
				class="form-control mr-sm-2" id="mySearch" type="text"
				placeholder="search" der="Search" aria-label="Search" name=lastname
				" onkeyup="myFunction()">
			<button type="submit" name="button" value="Submit">Submit</button>
		</form>
	</nav>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of party</h3>
			<hr>
			<div class="container text-left">

				<%-- <a href="<%=request.getContextPath()%>/registration"
					class="btn btn-success">Add Party</a> --%>
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
						searchAll ud = new searchAll();
						mylist = ud.searchAll();
					%>
					<%
						for (Party party : mylist) {
							System.out.println(party.getCity());
					%>

					<tr>
						<td><%=party.getFirstName()%></td>
						<td><%=party.getLastName()%></td>
						<td><%=party.getAddress()%></td>
						<td><%=party.getCity()%></td>
						<td><%=party.getZip()%></td>
						<td><%=party.getState()%></td>
						<td><%=party.getCountry()%></td>
						<td><%=party.getPhone()%></td>



						<td><a href="EditParty.jsp?id=<%=party.getPartyId()%>" />Edit</a>
						<td><a href="delete.jsp?id=<%=party.getPartyId()%>" />Delete</a>
					</tr>
					<%
						}
					%>






				</table>
			</ul>
		</div>
	</div>
</body>

</html>