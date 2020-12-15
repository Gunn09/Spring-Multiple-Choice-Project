<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Answer Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="container pt-4">

		<div class="jumbotron">
			<h1>Add Answers</h1>
			<br>

			<form:form action="addA" method="post">
				<div class="form-group">
					<label>Choose Question</label>
					<form:select path="id" class="form-control">
						<c:forEach items="${qid }" var="q">
							<option value="${q.id}">${q.question }</option>
						</c:forEach>
					</form:select>
				</div>
				<label>Create Multiple Choice for Answers</label>
				<div class="form-row mt-2 mb-3">
					<div class="col">
						<label>Option 1</label>
						<form:input path="option1" class="form-control" />
						<label>Option 2</label>
						<form:input path="option2" class="form-control" />
					</div>
					<div class="col">
						<label>Option 3</label>
						<form:input path="option3" class="form-control" />
						<label>Option 4</label>
						<form:input path="option4" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label>Choose Correct Answer</label>
					<div class="form-control">
						<form:checkbox path="a1" value="1" />
						<label>Option 1</label>
						<form:checkbox path="a2" value="1" />
						<label>Option 2</label>
						<form:checkbox path="a3" value="1" />
						<label>Option 3</label>
						<form:checkbox path="a4" value="1" />
						<label>Option 4</label>

					</div>
				</div>
				<input type="submit" value="Save" class="btn btn-primary" />

			</form:form>
		</div>
	</div>

</body>
</html>