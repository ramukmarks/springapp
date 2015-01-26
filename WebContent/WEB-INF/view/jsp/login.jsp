<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="login1.htm" method="post">
	<table cellpadding="5">
		<tr>
			<td>Username</td>
			<td> <input type="text" name="username">  </td>
		</tr>
		<tr>
			<td>Password</td>
			<td> <input type="password" name="password"> </td>
		</tr>
		<tr>
			<td></td>
			<td> <input type="submit" name="login" value="Login"/> </td>
		</tr>
		<c:if test="${param.err eq '1'}">
			<tr>
				<td></td>
				<td><p style="color: red">Invalid User Credentials.</p>	</td>
			</tr>
		</c:if>
		<c:if test="${param.out eq '1'}">
			<tr>
				<td></td>
				<td><p style="color: red">You have been logged out successfully!</p>	</td>
			</tr>
		</c:if>
	</table>
</form:form>
</body>
</html>