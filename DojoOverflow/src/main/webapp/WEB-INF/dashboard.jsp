<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<body>
<table class="table table-striped table-dark">
	<thead>
			<tr>
			<th>Question</th>
			<th>Tags</th>
			</tr>
	</thead>
	<tbody>		
		<c:forEach items = "${allQuestions}" var = "question">
			<tr>
				<td>${question.question_text}</td>
				<td>tags to do</td>
			</tr>
		</c:forEach>
		
	</tbody>
</table>
</body>
</html>