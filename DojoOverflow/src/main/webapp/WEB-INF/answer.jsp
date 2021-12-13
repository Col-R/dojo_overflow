<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Question Profile</title>
</head>
<body>
<div class = "container">
<div class = "row">
<h1>${question.question_text}</h1>
</div>
<div class = "row">
<div class = "col">
	<c:forEach items = "${question.tags }" var = "t">
	${tag.subject },
	</c:forEach>
</div>
</div>
<h3>Answers</h3>
<div class = "col-4">
<ul>
	<c:forEach items = "${question.answers}" var = "a">
	<li>${answer.answer_text }</li>
	</c:forEach>
</ul>
</div>
<div class = "col-4">
		<form:form method = "POST" action = "/addAnswer" modelAttribute = "answer">
		<div class = "col-7 mb-3">
			<form:label path = "answer_text" class= "form-label">Answer here:</form:label>
			<form:errors path  = "answer_text"></form:errors>
			<form:textarea class = "form-control" path = "answer_text" rows = "3"></form:textarea>
			<form:hidden path = "que" value = "${question.id }"/>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
<a href = "/">Home</a>
</div>




</div>

</body>
</html>