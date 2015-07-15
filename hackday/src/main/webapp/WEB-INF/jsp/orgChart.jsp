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
<title>Map Finder</title>
</head>
<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="/public/lib/js/bootstrap.min.js"></script>


<script> 
	var supervisor = {"superFirst": "${supervisor.firstName}",
		"superLast": "${supervisor.lastName}",
		"superTitle": "${supervisor.title}",
		"superPN": "${supervisor.phoneNumer}",
		"superCube":"${supervisor.cubicle}"
	}
	
	console.log(JSON.stringify(supervisor));
	
	
	function getPicture(employeeAlias){
		var picStr = "/public/lib/img/"+.png
		//return ${employeeList[i].alias};
		console.log("in function");
	}
</script>
<%--	<div>
		<c:if test="${not empty employeeList}">
			<ul>
				<c:forEach var="employee" items="${employeeList}">
					<li>${employee.firstName}</li>
					<li>${employee.lastName}</li>
					<li>${employee.title}</li>
					<li>${employee.phoneNumer}</li>
					<li>${employee.cubicle}</li>
				</c:forEach>
			</ul>

		</c:if>
	</div>

--%>

	<div class="tree">
	
		<ul>
			<li><a href="#"><img src="/public/lib/img/${supervisor.alias}.png"
					alt="HELLO" class="img-circle" style="margin: auto;"></a>
				<ul>
					<c:forEach var="employee" items="${employeeList}">
					<li><a href="#"><img src="/public/lib/img/${employee.alias}.png"
					alt="HELLO" class="img-circle" style="margin: auto;"></a>
						<ul>
						</ul></li>

					</c:forEach>
				</ul></li>
		</ul>
	</div>

</body>
</html>