<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
<table width="100%" bgcolor="grey" style="color: white">
	<tr>
		<td>View Employees | <a href="addEmployee.htm" style="color: lightblue">Add Employee</a></td>
		<td align="right">Welcome: <b><i><sec:authentication property="principal.username" /> </i></b> | <a href="<c:url value="j_spring_security_logout" />" > Logout</a></td>
	</tr>
</table>
<br><br><br>
<div align="center">
	<c:choose>
		<c:when test="${ empty employees}">
			No employee add yet.
		</c:when>
		
		<c:otherwise>
			<table bgcolor="grey" cellspacing="1" cellpadding="5">
				<tr bgcolor="white">
					<td>S.No</td>
					<td>Name</td>
				</tr>
				<c:forEach items="${employees }" var="employee" varStatus="cnt">
					<tr bgcolor="white">
						<td>${cnt.count}</td>
						<td><a href="updateEmployee.htm?employeeID=${employee.id }">${employee.name }</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>	
	</c:choose>
	<jsp:include page="messageDisplay.jsp"/>
</div>
</body>
</html>	