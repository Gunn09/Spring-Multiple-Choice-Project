<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Question Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>

<jsp:include page="index.jsp"></jsp:include>

	<div class="container pt-4">

		<div class="jumbotron">
			<h1>Add New Questions</h1>
			<br>

			<form:form action="insertQ" method="post">
				<div class="form-group">
					<label>Choose Exam</label>
					<form:select path="examid" class="form-control">
						<c:forEach items="${exam }" var="e">
							<option value="${e.id}">${e.name }</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="form-group">
					<label>Enter Question</label>
					<form:input path="question" class="form-control" />
				</div>
				<div class="form-group">
					<label>Enter Mark</label>
					<form:input type="number" path="mark" class="form-control" />
				</div>
				<input type="submit" value="Save" class="btn btn-primary" />
				<a href="index.jsp" class="btn btn-primary"> Back</a>

			</form:form>
		</div>
	</div>

</body>
</html>