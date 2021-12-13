<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<div class = "container">
<div class = "row">
<h1>What is your question?</h1>
</div>

<div class = "row">
	<form:form method = "POST" action = "/questions/new" modelAttribute = "question">
	
		<div class = "col-7 mb-3">
			<form:label path = "question_text" class= "form-label">Question here:</form:label>
			<form:errors path  = "question_text"></form:errors>
			<form:textarea class = "form-control" path = "question_text" rows = "3"></form:textarea>
		</div>
		
		<div class = "col-4 mb-3">
		<form:label path = "tags" class = "form-label">Add up to 3 tags ex: (Music, Gaming, Sports):</form:label>
		<form:errors path  = "tags"></form:errors>
		<form:input path = "tags" class = "form-control"/>	
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</div>	
</div>
</body>
</html>