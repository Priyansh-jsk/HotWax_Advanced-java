<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Delete Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>

	<div class="col-lg-8 mx-auto p-3 py-md-5">
		<header class="d-flex align-items-center pb-3 mb-5 border-bottom">
			<span class="fs-4">profile Deleted?</span> <br>
		</header>
		<form action="DeleteServlet" method="post">
			<div class="d-grid gap-2 d-md-block">
				<%
					String id = request.getParameter("id");
				%>
			
				<button type="submit" name="submit" value=<%=id%>>Delete</button>
	
			</div>
		</form>
	</div>

</body>
</html>