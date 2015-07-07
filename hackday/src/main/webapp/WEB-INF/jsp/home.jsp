<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Map Finder</title>
</head>
<body>
	<p>This will be the org chart's starting point!</p>

	<c:if test="${not empty employeeList}">
 
		<ul>
			<c:forEach var="employee" items="${employeeList}">
				<li>${employee.fName}</li>
				<li>${employee.lName}</li>
				<li>${employee.title}</li>
				<li>${employee.phoneNumer}</li>
				<li>${employee.cubicle}</li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>