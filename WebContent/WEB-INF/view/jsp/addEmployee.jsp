<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>
	<table width="100%" bgcolor="grey" style="color: white">
		<tr>
			<td>${param.employeeID eq null ? 'Add' : 'Update'} Employee | <a href="employee.htm" style="color: lightblue">View Employees</a></td>
			<td align="right">Welcome: <b><i>${user.username }</i></b> | <a href="#">Logout</a></td>
		</tr>
	</table>
	<br><br><br>
	<form action="${param.employeeID eq null ? 'addEmployee.htm' : 'updateEmployee.htm'}" method="post"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		<div align="center">
			<table cellpadding="5">
				<tr>
					<td>Name</td>
					<td> : </td>
					<td><input type="text" name="name" value="${employee.name}">
				</tr>
				<tr>
					<td>Company</td>
					<td> : </td>
					<td><input type="text" name="company" value="${employee.company}">
				</tr>
				<tr>
					<td>Department</td>
					<td> : </td>
					<td><input type="text" name="department" value="${employee.department}">
				</tr>
				<c:choose>
					<c:when test="${param.employeeID ne null }">
						<tr>
							<td colspan="2">
								<input type="button" value="Delete Employee" style="background-color: #DF0101; border: 0px; padding: 5px; border-radius: 10px"  onclick="fnDeleteEmployee()"> 
							</td>
							<td colspan="1">
								<input type="submit" value="Update Employee" style="background-color: olivedrab; border: 0px; padding: 5px; border-radius: 10px" > 
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">
							<td colspan="2">
								<input type="submit" value="Add Employee" style="background-color: olivedrab; border: 0px; padding: 5px; border-radius: 10px" > 
							</td>
					</c:otherwise>
				</c:choose>
				
			</table>
			<jsp:include page="messageDisplay.jsp"/>
		</div>
		<c:if test="${param.employeeID ne null }">
			<input type="hidden" name="id" value="${param.employeeID }" />
		</c:if>
		
	</form>
	
	<form action="deleteEmployee.htm" method="post" id="frmDeleteEmployee">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		<input type="hidden" name="id" value="${param.employeeID }" />
	</form>
</body>
<script>
	function fnDeleteEmployee(){
		if(confirm("Do you wish to delete the employee")) {
			document.getElementById("frmDeleteEmployee").submit();
		}
	}		
</script>
</html>