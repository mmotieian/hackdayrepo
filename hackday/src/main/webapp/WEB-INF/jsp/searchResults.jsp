<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/public/lib/css/styles.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee View</title>
</head>
<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="/public/lib/js/bootstrap.min.js"></script>

	<h1 style="margin-top:100px; margin-left:490px;">
	Results
	</h1>

	<div style="margin-top:100px;">
			<table class="table">
				<thead>
					<tr>
						<td>
							First Name
						</td>
						<td>
							Last Name
						</td>
						<td>
							Alias
						</td>
					</tr>	
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employeeList}">
					<tr>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td> 
						<td>${employee.alias}</td>
						<td>
	  					<button type="button" class="btn btn-default pull-right" onclick="location.href='/mapPage'">View Map</button>
	  					</td>
	  					<td>
	  					<button type="button" onclick="window.location='/orgChart/${employee.alias}';" class="btn btn-default pull-right">View Organization Chart</button>
						</td>
					</tr>	
					</c:forEach>
				</tbody>
			</table>
	</div>

</body>
</html>

