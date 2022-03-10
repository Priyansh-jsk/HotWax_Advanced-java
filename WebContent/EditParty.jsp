<%@page import="model.Party"%>
 <%@page import="dao.SearchByPartyId"%> 

<html>
<head>
<title>Party Management App</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Party Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>"
					class="nav-link">Party</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<form action="UpdateServlet" method="Post">

				<%
					int partyID = Integer.parseInt(request.getParameter("id"));
							SearchByPartyId update = new SearchByPartyId();
							
							Party party = update.searchById(partyID);
				%> 

					<fieldset class="form-group">
						<label>First Name</label> <input type="text"
							value=<%=party.getFirstName()%> class="form-control" name="firstname"
							required="required">


						<fieldset class="form-group">
							<label>Last Name</label> <input type="text"
								value=<%=party.getLastName()%> class="form-control" name="lastname"
								required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>address</label> <input type="text"
								value="<%=party.getAddress()%>" class="form-control" name="address"
								required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>City</label> <input type="text" value="<%=party.getCity()%>"
								class="form-control" name="city"
								required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Zip</label> <input type="text" value="<%=party.getZip()%>"
								class="form-control" name="zip"
								required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>State</label> <input type="text" value="<%=party.getState()%>"
								class="form-control" name="state"
								required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Country</label> <input type="text"
								value="<%=party.getCountry()%>" class="form-control" name="country"
								required="required">
						</fieldset>
						<fieldset class="form-group">
							<label>Phone</label> <input type="text" value="<%=party.getPhone()%>"
								class="form-control" name="phone"
								required="required">
						</fieldset>
										<%-- <p><%=p.getPartyId() %></p> --%>
						<button type="submit" name="Update" value=<%=partyID%>
							class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
