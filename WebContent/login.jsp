<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page..</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<center>
		<div align="center" class="classone">

			<fieldset>
				<%
					String status = (String) request.getAttribute("status");
					if (status != null) {
						out.println(status);
					}
				%>
				<legend style="color: white;">
					<h1>Login</h1>
				</legend>
				<div class="image">
					<img
						src="data:image/png;base64,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"></img>
				</div>
				<form action="login" method="post" class="max">
					<table class="table-style">
						<td>Email</td>
						<td><input type="email" id="email" name="email"></td>
						<td><span style="color: yellow" id="email">*</span></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" id="password" name="password"></td>
							<td><span style="color: red" id="password" name="passowrd">
									<%
										if (null != request.getAttribute("Msg")) {
											out.println(request.getAttribute("Msg"));
										}
									%>
							</span></td>
						</tr>
						<tr>
							<td><input class="btn" type="submit" value="Login"></td>
						</tr>
					</table>
				</form>
				<br>
				<hr>
				<p style="color: white; font-size: 18px; font-weight: 900;">
					New user?<a href="registration.jsp"
						style="color: white; font-size: 18px; font-weight: 900;"
						target="_blank">Sign Up</a>
				</p>
			</fieldset>
		</div>
	</center>
</body>
</html>