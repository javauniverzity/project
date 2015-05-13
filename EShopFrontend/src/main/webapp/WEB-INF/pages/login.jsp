<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="j_spring_security_check">
		<table class="form" style="margin: 0 auto;">
			<tr>
				<td><label for="j_username" id="usernameTitle">username</label></td>
				<td><input type="text" name="j_username" id="j_username" value="" /></td>
			</tr>
			<tr>
				<td><label for="j_password" id="passwordTitle">password</label></td>
				<td><input type="password" name="j_password" id="j_password"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="checkbox" name="_spring_security_remember_me"
					id="_spring_security_remember_me" checked="checked"
					style="float: right;" /> <label for="_spring_security_remember_me"
					style="float: right;">remember</label>
				</td>
			</tr>
		</table>
		<div style="text-align: center;">
			<input id="submit" type="submit" value="login"/>
		</div>

	</form>

</body>
</html>