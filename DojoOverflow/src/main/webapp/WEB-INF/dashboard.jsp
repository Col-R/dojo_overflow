<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<div class = "container ">
<div class = "row justify-content-lg-center">

<div class = "col-8">
<h1>Questions Dashboard</h1>
<table class="table">
	<thead>
			<tr>
			<th>Question</th>
			<th>Tags</th>
			</tr>
	</thead>
	<tbody>		
		<c:forEach items = "${allQuestions}" var = "question">
			<tr>
				<td><a href = "/question/${question.id}">${question.question_text}</a></td>
				<td>
					<c:forEach items = "${question.qtags }" var = "t">
					${t.subject },
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
		<a href = "/questions/new">Submit a question of your own!</a>
	</tbody>
</table>
</div>
</div>
</div>
</body>
</html>