<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Type Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.cards {
		display: flex;
		flex-wrap: wrap;
		gap: 1rem;
		padding-top: 1.5rem;
}

.card {
		display: flex;
		flex-direction: column;
		width: 100%;
		overflow: hidden;
}
</style>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="container pt-4">
		<h2>Choose Exam</h2><br>
		<div class="cards">
			<c:forEach items="${exam}" var="e">
				<div class="card" style="width: 200px">
					<div class="card-body">
						<p>ID : ${e.id}</p>
						<p>Q : ${e.name}</p>
						<a href="showQ/${e.id}" class="btn btn-info">Test</a>
					</div>
				</div>
			</c:forEach>
		</div>



	</div>

</body>
</html>