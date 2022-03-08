
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
				<li><a href="<%=request.getContextPath()%>index.jsp"
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
					int id = Integer.parseInt(request.getParameter("id"));
							SearchByPartyId ud = new SearchByPartyId();
							
							Party  p = ud.searchById(id);
				%> 

					<fieldset class="form-group">
						<label>First Name</label> <input type="text"
							value=<%=p.getFirstName()%> class="form-control" name="firstname"
							required="required">


						<fieldset class="form-group">
							<label>Last Name</label> <input type="text"
								value=<%=p.getLastName()%> class="form-control" name="lastname"
								required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>address</label> <input type="text"
								value="<%=p.getAddress()%>" class="form-control" name="address">
						</fieldset>

						<fieldset class="form-group">
							<label>City</label> <input type="text" value="<%=p.getCity()%>"
								class="form-control" name="city">
						</fieldset>
						<fieldset class="form-group">
							<label>Zip</label> <input type="text" value="<%=p.getZip()%>"
								class="form-control" name="zip">
						</fieldset>
						<fieldset class="form-group">
							<label>State</label> <input type="text" value="<%=p.getState()%>"
								class="form-control" name="state">
						</fieldset>
						<fieldset class="form-group">
							<label>Country</label> <input type="text"
								value="<%=p.getCountry()%>" class="form-control" name="country">
						</fieldset>
						<fieldset class="form-group">
							<label>Phone</label> <input type="text" value="<%=p.getPhone()%>"
								class="form-control" name="phone">
						</fieldset>
										<%-- <p><%=p.getPartyId() %></p> --%>
						<button type="submit" name="Update" value=<%=id%>
							class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
