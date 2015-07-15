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

	<div style="margin-left:100px; margin-top:100px;">
			<ul>
				<c:forEach var="employee" items="${employeeList}">
					<h1>${employee.firstName}
					<div class="btn-group" role="group" aria-label="...">
  						<!--<button type="button" class="btn btn-default pull-right">View Map</button>-->
  						<button type="button" class="btn btn-default pull-right">View Organization Chart</button>
					</div>
					</h1>
				</c:forEach>
			</ul>
	</div>

</body>
</html>