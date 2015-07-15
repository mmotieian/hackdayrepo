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

	<h1 style="margin-top:100px; margin-left:490px;">
	Find an Employee
	</h1>
	<h2 style=" margin-left:250px;">
	Enter employee name (first or last), alias, or cube number 
	</h2>

	<div class="row search">
            <div class="col-md-8 col-md-offset-2" style="margin-top:50px; margin-left:520px;">
                <form class="form-inline" action="/searchResults/employee" >
                    <div class="form-group">
                        <label class="sr-only" for="">Enter search terms</label>
                        <input type="search" class="form-control" name="employee" placeholder="Enter employee info">
                    </div>
                    <button type="submit" id="s" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span>
                    </button>
                </form>
            </div>
    </div>
	

</body>
</html>